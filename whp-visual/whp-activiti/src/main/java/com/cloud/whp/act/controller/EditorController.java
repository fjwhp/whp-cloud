
package com.cloud.whp.act.controller;

import com.cloud.whp.act.service.EditorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author whp
 * @date 2018/9/25
 */
@RestController
@RequestMapping("/service")
@AllArgsConstructor
public class EditorController {
	private final EditorService editorService;

	@GetMapping("/editor/stencilset")
	public Object getStencilset() {
		return editorService.getStencilset();
	}

	@GetMapping(value = "/model/{modelId}/json")
	public Object getEditorJson(@PathVariable(value = "modelId") String modelId) {
		return editorService.getEditorJson(modelId);
	}

	@PutMapping("/model/{modelId}/save")
	public void saveModel(@PathVariable(value = "modelId") String modelId, String name, String description,
						  @RequestParam("json_xml") String jsonXml, @RequestParam("svg_xml") String svgXml) {
		editorService.saveModel(modelId, name, description, jsonXml, svgXml);
	}
}
