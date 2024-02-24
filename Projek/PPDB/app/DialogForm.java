import android.app.DialogFragment;

public class DialogForm extends DialogFragment {
    String nama, nisn, asal, tujuan, jalur, key, pilih;

    public DialogForm(String nama, String nisn, String asal, String tujuan, String jalur, String key, String pilih){
        this.nama = nama;
        this.nisn = nisn;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jalur = jalur;
        this.key = key;
        this.pilih = pilih;
    }
}
