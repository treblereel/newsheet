package org.treblereel.opensheet.shared.dto;

import java.io.Serializable;
import java.util.List;

import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.TreeStore.TreeNode;

public class TreeNodeDTO implements Serializable,
		TreeStore.TreeNode<TreeNodeDTO> {

	private static final long serialVersionUID = 6469211851548646236L;

	private Long id;
	private String name;

	protected TreeNodeDTO() {

	}

	public TreeNodeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<? extends TreeNode<TreeNodeDTO>> getChildren() {
		return null;
	}

	@Override
	public TreeNodeDTO getData() {
		return this;
	}

}
