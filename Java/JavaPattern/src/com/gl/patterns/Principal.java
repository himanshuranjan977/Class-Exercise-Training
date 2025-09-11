package src.com.gl.patterns;
public class Principal {
    public String name;
    public String education;

    private static Principal onePrincipal;

    private  Principal(String name, String education){
        this.name=name;
        this.education=education;


    }
    public static Principal getInstance(String name, String education){
        if(onePrincipal ==null){
            onePrincipal =new Principal(name,education);
        }
        return  onePrincipal;
    }

}
