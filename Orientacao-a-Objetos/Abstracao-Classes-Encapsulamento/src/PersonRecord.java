public record PersonRecord(String name, int age) {

    public PersonRecord (String name){
        this(name, 1);
    }
}
