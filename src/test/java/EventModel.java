import java.util.Map;

public class EventModel {
    private String nameProject,
            language;

    private int codeProject,
            idProject;

    private Map<String, Object> creator;
    private Map<String, Object> administrator;

    public String getNameProject() {
        return nameProject;
    }

    public void getNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public Integer getCodeProject() {
        return codeProject;
    }

    public void getCodeProject(int codeProject) {
        this.codeProject = codeProject;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void getIdProject(int idProject) {
        this.idProject = idProject;
    }

    public Map<String, Object> getCreator() {
        return creator;
    }

    public void getCreator(Map<String, Object> creator) {
        this.creator = creator;
    }

    public Map<String, Object> getAdministrator() {
        return administrator;
    }

    public void getAdministrator(Map<String, Object> administrator) {
        this.administrator = administrator;
    }

    public String getLanguage() {
        return language;
    }

    public void getLanguage(String language) {
        this.language = language;
    }
}

