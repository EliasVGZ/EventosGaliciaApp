package modelos;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Administrador {
    private String nombre;
    private String contrasenha;

    private FirebaseFirestore mfirestore;

    // Constructor
    public Administrador(String nombre) {
        this.nombre = nombre;
    }



    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    // Métodos
    public void crearEvento(Evento evento) {
        // Implementación para crear evento
    }

    public void editarEvento(Evento evento) {
        // Implementación para editar evento
    }

    public void eliminarEvento(Evento evento) {
        // Implementación para eliminar evento
    }

    public void crearOrganizador(Organizador organizador) {
        // Implementación para crear organizador
    }

    public void subirImagenEvento(Evento evento, Uri fileUri) {
        // Obtén la referencia a Firebase Storage
        FirebaseStorage storage = FirebaseStorage.getInstance();

        // Crea una referencia a la ubicación donde deseas subir el archivo
        // En este caso, es la carpeta "conciertos" y el nombre del archivo es el nombre del evento
        StorageReference storageRef = storage.getReference().child("conciertos/" + evento.getNombre() + ".jpg");

        // Sube el archivo
        UploadTask uploadTask = storageRef.putFile(fileUri);
        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // El archivo se subió correctamente
                // Puedes obtener la URL de descarga así:
                storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Aquí tienes la URL de descarga del archivo
                        String downloadUrl = uri.toString();
                        // Aquí puedes hacer algo con la URL de descarga, como guardarla en la base de datos
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Hubo un error al subir el archivo
            }
        });
    }


}
