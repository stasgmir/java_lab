public class Coffee extends Food{
    public String getAroma() {
        return type;
    }

    public void setAroma(String Aroma) {
        this.type = type;
    }

    private String type;
    public Coffee(String type) {
        super("Кофе");
        this.type = type;
    }

    @Override
    public void consume() {
        System.out.print(  this.toString()+  " выпито ");

    }
    @Override
    public String toString(){
        return "кофе  " + type;
    }
}
