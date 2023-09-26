import java.util.*;
import java.util.stream.Collectors;

public class MainBook {

    public static void main(String[] args){
        Set<NoteBook> books = new HashSet<>();
        fillRandBooks(books, 5);
        printSet(books);

        //Map<Integer, String> mapCrit = new HashMap<>();
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите критерии для фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Диагональ");
        System.out.println("0 - Завершить выбор");

        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Минимальный объем ОЗУ:");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Минимальный объем ЖД:");
                    filters.put("hdd", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Операционная система:");
                    filters.put("os", scanner.next());
                    break;
                case 4:
                    System.out.println("Цвет:");
                    filters.put("color", scanner.next());
                    break;
                case 5:
                    System.out.println("Диагональ:");
                    filters.put("diag", scanner.next());
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        Set<NoteBook> filteredBooks = books.stream()
                .filter(book -> filters.getOrDefault("ram", 0) instanceof Integer && book.ramsize >= (int) filters.getOrDefault("ram", 0))
                .filter(book -> filters.getOrDefault("hdd", 0) instanceof Integer && book.vol_hdd >= (int) filters.getOrDefault("hdd", 0))
                .filter(book -> filters.getOrDefault("os", "").equals("") || book.opersys.equalsIgnoreCase((String) filters.getOrDefault("os", "")))
                .filter(book -> filters.getOrDefault("color", "").equals("") || book.color.equalsIgnoreCase((String) filters.getOrDefault("color", "")))
                .filter(book -> filters.getOrDefault("diag", 0) instanceof Double && book.diag >= (double) filters.getOrDefault("diag", 0))
                .collect(Collectors.toSet());

        System.out.println("Отфильтрованные ноутбуки:");


        Set<NoteBook> res = new HashSet<>();
        for (NoteBook book : filteredBooks) {
            res.add(book);
        }
        printSet(res);
       // System.out.println(filters);
    }


    public static  String randValue(String[] arr){
        Random rand = new Random();
        int rnd = rand.nextInt(arr.length);
        return arr[rnd];
    }
    public static void fillRandBooks(Set<NoteBook> set, int count){
        String[] brends = new String[]{"Dell", "Acer", "HP", "Sony", "Asus"};
        String[] models = new String[]{"111", "222", "333", "444", "555","666", "777", "8888", "999"};
        String[] sysems = new String[]{"Win7", "Win8", "Win10", "Linux", "MacOS"};
        String[] processors = new String[]{"celeron", "Pentium", "Atom", "Rizen"};
        String[] colors = new String[]{"White", "Blakc", "Seelver","Pink"};
        String[] diags = new String[]{"11.2", "12.0", "13.1", "13.7", "14.0", "15.6"};
        String[] rams = new String[]{"2", "4", "8", "16", "32"};
        String[] hdds = new String[]{"128", "256", "512", "1024"};

        for(int i = 0; i<count; i++ ){
            NoteBook book = new NoteBook();
            book.brend = randValue(brends);
            book.model = randValue(models);
            book.opersys = randValue(sysems);
            book.processor = randValue(processors);
            book.color = randValue(colors);
            book.diag = Double.parseDouble(randValue(diags));
            book.ramsize = Integer.parseInt(randValue(rams));
            book.vol_hdd = Integer.parseInt(randValue(hdds));
            set.add(book);
        }
    }
    static void printSet(Set<NoteBook> set){
        for (NoteBook book: set){
            System.out.println(book);
        }

    }
}

