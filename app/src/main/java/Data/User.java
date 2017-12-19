package Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aprianto on 12/15/2017.
 */

public class User implements Parcelable {
    private String email;
    private String pass;
    private String namalengkap;
    private String tlp;
    //private Pinjaman pinjam;
    //private Buku buku;
    private String idmembers;



    //getter and setter
    protected String[][] data = new String[][] {
            {"aprianto@gmail.com","anto","Aprianto","0852348673","0002"},
            {"agungashari@gmail.com","agung","Agung Ashari","086567578","0003"},
            {"ahmaderil@gmail.com","eril","Ahmad Eril","0852348673","0001"}


    };

    public User(String email) {
        this.email = email;
        this.caridata();

    }

    public void setData(String[][] data) {
        this.data =data;
    }


    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private void caridata() {
        for(int i=0; i<this.data.length; i++){
            if(this.email.equals(this.data[i][0])) {
                this.pass = this.data[i][1];
                this.namalengkap = this.data[i][2];
                this.tlp = this.data[i][3];
                this.idmembers = this.data[i][4];
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.caridata();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        this.caridata();
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    public String getIdmember() {
        return idmembers;
    }

    public void setIdmember(String idmember) {
        this.idmembers = idmember;
    }

    //Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
        dest.writeString(this.pass);
        dest.writeString(this.namalengkap);
        dest.writeString(this.tlp);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.email = in.readString();
        this.pass = in.readString();
        this.namalengkap = in.readString();
        this.tlp = in.readString();
    }

}
