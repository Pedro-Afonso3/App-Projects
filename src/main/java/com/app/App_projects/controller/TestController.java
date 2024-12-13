package com.app.App_projects.controller;

import com.app.App_projects.DTO.ProjetosDTO;
import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.services.projetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private com.app.App_projects.services.projetoService projetoService;

    List<Projetos> projetosDTOList = new ArrayList<>();

    //TESTE VINCULADO PARA PUXAR A LEITURA DOS PROJETOS CADASTRADOS
    @RequestMapping("/listarProjetos") //DEPOIS DE ANOS VI QUE TEM ALGO COM COLOCAR O REQUEST PARA PUXAR
    public String listarProjetos(Model model) {
        List<ProjetosDTO> projetos = projetoService.showAllProjetos();
        System.out.println(projetos); // Verifica se a lista está preenchida
        model.addAttribute("projects", projetos);
        return "projetos";
    }

}
