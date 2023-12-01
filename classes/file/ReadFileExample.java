
medias.addAll(ReadFromFile("data.csv",Music.class,","));

static private <T> LinkedList<T> ReadFromFile(String file, Class<T> reflector, String separator){
    LinkedList<T> res = new LinkedList<T>();
    try {
        BufferedReader f = new BufferedReader(new FileReader(new File(file)));
        String input;
        while ((input = f.readLine()) != null) {
            String[] line = input.split(separator);
            T instance = reflector.getDeclaredConstructor(String[].class).newInstance(line);
            res.add(reflector.getDeclaredConstructor(String[].class).newInstance(line));
        }
    } catch (Exception e) {
        System.out.println("Nem írtál valamit el?");
    }
    return res;
}

static public <T> ArrayList<T> load(Class<T> reflector) {
  ArrayList<T> list = new ArrayList<T>();
  for (int i=0; i<t.getRowCount(); i++) {
    list.add(reflector.getDeclaredConstructor(String[].class).newInstance(t.getRow(i)));

  }
  return list;
}