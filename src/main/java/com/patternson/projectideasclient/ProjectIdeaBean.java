package com.patternson.projectideasclient;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProjectIdeaBean implements Serializable {

    public List<ProjectIdeasDTO> getProjectIdeas() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/projectideas/ideas");
        WebTarget listTarget = webTarget.path("list");


//     return listTarget.request(MediaType.APPLICATION_XML).get(ProjectIdeasDTO.class);
        return listTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<ProjectIdeasDTO>>() {});
    }
}
