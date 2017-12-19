package Data;

import android.os.Parcel;

/**
 * Created by Aprianto on 12/15/2017.
 */

public class Members extends User {
        private String id_members = null;
        private Pinjaman pinjaman;


        public Members(String email) {
            this.setEmail(email);
            this.caridata();
        }

        private void caridata() {
            for(int i=0; i<this.data.length; i++){
                if( this.getEmail().equals( this.data[i][0] ) ){
                    this.setId_members( this.data[i][4] );
                    this.setPass( this.data[i][1] );
                    this.setNamalengkap( this.data[i][2] );
                    this.setTlp( this.data[i][3] );
                    this.pinjaman = new Pinjaman( this.id_members );
                }
            }
        }


        //getter and setter
        public String getId_members() {
            return id_members;
        }

        public void setId_members(String id_members) {
            this.id_members = id_members;
        }

        public Pinjaman getPinjaman() {
            return pinjaman;
        }

        public void setPinjaman(Pinjaman pinjaman) {
            this.pinjaman = pinjaman;
        }


        //Parcelable
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(this.id_members);
            dest.writeParcelable(this.pinjaman, flags);
        }

        protected Members(Parcel in) {
            super(in);
            this.id_members = in.readString();
            this.pinjaman = in.readParcelable(Pinjaman.class.getClassLoader());
        }

        public static final Creator<Members> CREATOR = new Creator<Members>() {
            @Override
            public Members createFromParcel(Parcel source) {
                return new Members(source);
            }

            @Override
            public Members[] newArray(int size) {
                return new Members[size];
            }
        };
}
