package yanomas.android.gt.myapplication.vista;

/**
 * Created by David on 27/11/2015.
 */
public class Publicacion {

    private String nickname;
    private String titulo;
    private String comentario;

    public Publicacion(String nickname, String titulo, String comentario) {
        this.nickname = nickname;
        this.titulo = titulo;
        this.comentario = comentario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
