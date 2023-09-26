public class NoteBook {
    String brend, model, opersys, processor, color;
    double diag;
    int ramsize, vol_hdd;

    @Override
    public String toString(){
        return  "brend: " + brend +   ", model: " + model +
                ", processor: " + processor + ", hdd: " + vol_hdd +" Gb" +
                ", ram size: "+ ramsize+" Gb" + ", color: " + color+
                ", diag: "+ diag + ", OperSystem: "+opersys;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof NoteBook)){
            return false;
        }
        NoteBook book = (NoteBook) obj;
        return brend.equals(book.brend) && model.equals(book.model)
                && opersys.equals(book.opersys) && processor.equals(book.processor)
                && color.equals(book.color) && diag == book.diag && ramsize == book.ramsize
                && vol_hdd == book.vol_hdd;
    }

    @Override
    public int hashCode() {
        return brend.hashCode() + 7 * model.hashCode() + 11 * opersys.hashCode() + 5*processor.hashCode()
                + 13*color.hashCode() + 17*(int)diag + 23*ramsize +29*vol_hdd;
    }


}
