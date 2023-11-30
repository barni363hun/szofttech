
    medias.addAll(ReadFromFile("data.csv",Music.class,","));
    
static private <T> LinkedList<T> ReadFromFile(String file, Class<T> reflector, String separator){
    LinkedList<T> res = new LinkedList<T>();
    try {
        BufferedReader f = new BufferedReader(new FileReader(new File(file)));
        String input;
        while ((input = f.readLine()) != null) {
            String[] line = input.split(separator);
            T instance = reflector.getDeclaredConstructor(String[].class).newInstance((Object) line);
            res.add(instance);
        }
    } catch (Exception e) {
        System.out.println("Nem írtál valamit el?");
    }
    return res;
}