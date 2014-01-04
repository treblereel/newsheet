package org.treblereel.opensheet.client.mvc.view.impl.timesheet;

import java.util.ArrayList;
import java.util.List;

import org.treblereel.opensheet.client.i18n.constants.TimesheetConstants;
import org.treblereel.opensheet.client.mvc.view.TimesheetView;
import org.treblereel.opensheet.client.utils.FakeTreeStore;
import org.treblereel.opensheet.shared.dto.SheetDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.event.CompleteEditEvent;
import com.sencha.gxt.widget.core.client.event.CompleteEditEvent.CompleteEditHandler;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.editing.GridInlineEditing;
import com.sencha.gxt.widget.core.client.treegrid.TreeGrid;

public class TimesheetViewImpl extends Composite implements TimesheetView {
	private TimesheetPresenter presenter;
	private List<ColumnConfig<SheetDTO, ?>> columns = new ArrayList<ColumnConfig<SheetDTO, ?>>();
	private ColumnModel<SheetDTO> cm;
	private ColumnConfig<SheetDTO, String> columnName;
	private Button button;
	private TreeGrid<SheetDTO> tree;
	private TreeStore<SheetDTO> store = new TreeStore<SheetDTO>(
			new KeyProvider());
	private GridInlineEditing<SheetDTO> editing = new GridInlineEditing<SheetDTO>(tree);
	private TimesheetConstants msgs = (TimesheetConstants) GWT
			.create(TimesheetConstants.class);
	private List<ColumnConfig<SheetDTO, String>> dayColumns  = new ArrayList<ColumnConfig<SheetDTO, String>>();

	class KeyProvider implements ModelKeyProvider<SheetDTO> {
		@Override
		public String getKey(SheetDTO item) {
			return (item instanceof SheetDTO ? "f-" : "m-")
					+ item.getId().toString();
		}
	}

	public TimesheetViewImpl() {
		initColumns();
		initTree();
		loadData();

	}

	private void loadData() {
		for (SheetDTO child : FakeTreeStore.getSheetData().getChildren()) {
			store.add(child);
			if (child.getChildren().size() > 0) {
				processFolder(store, child);
			}
		}
	}

	private void processFolder(TreeStore<SheetDTO> store, SheetDTO folder) {
		for (SheetDTO child : folder.getChildren()) {
			store.add(folder, (SheetDTO) child);
			if (child.getChildren().size() > 0) {
				processFolder(store, (SheetDTO) child);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void initTree() {
		tree = new TreeGrid<SheetDTO>(store, cm, columnName);
		tree.getView().setAutoExpandColumn(columnName);
		tree.getView().setAutoFill(true);
		tree.getView().setColumnLines(true);
		System.out.println("before  " + tree.getOffsetWidth());
		initWidget(tree);
		initTreeEditor();
		
		
		
	}
	
	private void initTreeEditor(){
		editing = new GridInlineEditing<SheetDTO>(tree);
		for(ColumnConfig<SheetDTO, ?> c: dayColumns){
			editing.addEditor((ColumnConfig<SheetDTO, String>)c, new TextField());
		}
		editing.addCompleteEditHandler(new CompleteEditHandler<SheetDTO>(){
			@Override
			public void onCompleteEdit(CompleteEditEvent<SheetDTO> event) {

			}
		});
	}

	private void initColumns() {
		initNameColumn();
		initDayColumns();
		cm = new ColumnModel<SheetDTO>(columns);
	}

	private void initNameColumn() {
		columnName = new ColumnConfig<SheetDTO, String>(
				new ValueProvider<SheetDTO, String>() {
					@Override
					public String getValue(SheetDTO object) {
						return object.getName();
					}

					@Override
					public void setValue(SheetDTO object, String value) {
						object.setName(value);
					}

					@Override
					public String getPath() {
						return "name";
					}
				});
		columnName.setHeader(SafeHtmlUtils.fromString(msgs.columnName()));
		columnName.setSortable(false);
		columnName.setMenuDisabled(true);
		columnName.setResizable(false);
		columns.add(columnName);
	}

	@SuppressWarnings("unchecked")
	private void initDayColumns() {
		ColumnConfig<SheetDTO, String> cc;
		for (Integer i = 1; i < 32; i++) {
			final Integer temp = i;
			cc = new ColumnConfig<SheetDTO, String>(
					new ValueProvider<SheetDTO, String>() {
						@Override
						public String getValue(SheetDTO object) {
							if (object.getHour(temp).getHour() == 0) {
								return "";
							} else
								return object.getHour(temp).getHour()
										.toString();
						}

						@Override
						public void setValue(SheetDTO object, String value) {
							object.getHour(temp).setHour(
									Integer.parseInt(value));
						}

						@Override
						public String getPath() {
							return temp.toString();
						}
					});
			cc.setHeader(SafeHtmlUtils.fromString(i.toString()));
			cc.setWidth(30);
			cc.setMenuDisabled(true);
			cc.setSortable(false);
			cc.setFixed(true);
			cc.setResizable(false);
			columns.add(cc);
			dayColumns.add(cc);
		}
	}

	@Override
	public void setPresenter(TimesheetPresenter presenter) {
		this.presenter = presenter;
	}

	public Widget asWidget() {
		return this;
	}

}
