public interface InterfazOperaciones {

    public String operacion(String operacion);

    public String[] separarNumeros(String operacion);

    public String[] separarOperadores(String operacion);

    public String hacerOperacion(String[] numeros, String[] operaciones);
}
