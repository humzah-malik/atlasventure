public class ThemeLevelData {
    public String[] questions;
    public String[][] options;
    public String[] correctAnswers;
    public String[] hints;
    public String[] imagePaths;
    public String[] funFacts;

    public ThemeLevelData() {}
    public void initialize(String[] questions, String[][] options, String[] correctAnswers, String[] hints, String[] imagePaths, String[] funFacts) {
        this.questions = questions;
        this.options = options;
        this.correctAnswers = correctAnswers;
        this.hints = hints;
        this.imagePaths = imagePaths;
        this.funFacts = funFacts;
    }
    public ThemeLevelData(int level) {
        switch (level) {
            case 1:
                initializeLandmarks();
                break;
            case 2:
                initializeTraditionalClothing();
                break;
            case 3:
                initializeFlags();
                break;
            default:
                System.out.println("Otherss");
        }
    }
    private void initializeLandmarks() {
        String[] questions = {
                "Where can you find the Eiffel Tower?",
                "The Great Sphinx of Giza, with the body of a lion and the head of a human, is situated in which country?",
                "Machu Picchu, an ancient Incan city set high in the Andes Mountains, is found in which country?",
                "Christ the Redeemer, the colossal statue of Jesus Christ, overlooks which city?",
                "The Hagia Sophia, famous for its massive dome and as a symbol of Byzantine architecture, is located in which city?"
        };
        String[][] options = {
                {"A) London, United Kingdom", "B) Rome, Italy", "C) Paris, France", "D) Berlin, Germany"},
                {"A) Jordan", "B) Egypt", "C) Greece", "D) Iran"},
                {"A) Colombia", "B) Bolivia", "C) Peru", "D) Ecuador"},
                {"A) Lisbon, Portugal", "B) Barcelona, Spain", "C) Buenos Aires, Argentina", "D) Rio de Janeiro, Brazil"},
                {"A) Athens, Greece", "B) Sofia, Bulgaria", "C) Istanbul, Turkey", "D) Jerusalem, Israel"}
        };
        String[] correctAnswers = {"C) Paris, France", "B) Egypt", "C) Peru", "D) Rio de Janeiro, Brazil", "C) Istanbul, Turkey"};
        String[] hints = {
                "This city is known as the 'City of Light' and is renowned for its art, fashion, and culinary delights.",
                "This country is home to one of the world's earliest and longest rivers, a cradle of ancient civilization.",
                "This country is famous for its part of the Amazon rainforest and the Andes Mountains.",
                "This city is famous for its carnival, samba, and stunning beaches like Copacabana.",
                "This city, straddling two continents, was historically known as Byzantium and Constantinople."
        };
        String[] imagePaths = {"/images/Paris.jpg", "/images/Cairo.jpg", "/images/MachuPicchu.jpg", "/images/Rio.jpg", "/images/Istanbul.jpg"};
        String[] funFacts = {
                "The Eiffel Tower can actually be significantly taller during the summer due to thermal expansion. The iron structure expands when heated by the sun, making the tower grow by up to 6 inches.",
                "The Great Pyramid of Giza is the oldest of the Seven Wonders of the Ancient World and the only one to remain largely intact. It was built as a tomb for Pharaoh Khufu over 4,500 years ago.",
                "Machu Picchu, the ancient Incan citadel located in the Andes Mountains, is one of the most famous archaeological sites in the world and a UNESCO World Heritage Site.",
                "Rio de Janeiro is home to the largest urban forest in the world, Tijuca National Park, which covers an area of over 32 square kilometers within the city limits.",
                "Istanbul is the only city in the world that straddles two continents, Europe and Asia, separated by the Bosphorus Strait. It has been a significant cultural and commercial center for over 2,000 years."
        };
        initialize(questions, options, correctAnswers, hints, imagePaths, funFacts);
    }

    private void initializeTraditionalClothing() {
        String[] questions = {
                "Identify the country where the 'Sari', a traditional attire, is typically worn.",
                "Identify the country associated with this traditional garment, a Kilt.",
                "The 'Kimono', characterized by long sleeves and a wraparound design, is a traditional garment from which country?",
                "Which country is celebrated for its vibrant festivals, delicious cuisine like tacos and enchiladas, and ancient Mayan and Aztec ruins?",
                "The 'Lederhosen', knee-length leather trousers often worn with suspenders, are a traditional outfit for which country's festivals?"
        };
        String[][] options = {
                {"A) Pakistan", "B) Bangladesh", "C) India", "D) Nepal"},
                {"A) Ireland", "B) Scotland", "C) Wales", "D) England"},
                {"A) China", "B) Korea", "C) Thailand", "D) Japan"},
                {"A) Spain", "B) Mexico", "C) Colombia", "D) Panama"},
                {"A) Austria", "B) Switzerland", "C) Germany", "D) Liechtenstein"}
        };
        String[] correctAnswers = {"C) India", "B) Scotland", "D) Japan", "B) Mexico", "C) Germany"};
        String[] hints = {
                "This country is not only the world's largest democracy but also famous for its diverse cultures, languages, and the Bollywood film industry.",
                "This garment is from a country known for its unique Highland games, whisky distilleries, and being part of the United Kingdom.",
                "This nation is an island country in East Asia, known for its technological advancements, cherry blossoms, and ancient temples.",
                "This country is celebrated for its vibrant festivals, delicious cuisine like tacos and enchiladas, and ancient Mayan and Aztec ruins.",
                "This European country is recognized for its engineering, Oktoberfest beer celebration, and historical figures like Beethoven and Einstein."
        };
        String[] imagePaths = {"/images/TajMahal.jpg", "Scotland.jpg", "3.jpg", "4.jpg", "5.jpg"};
        String[] funFacts = {
                "India is the world's largest producer of milk, with the dairy industry playing a significant role in the country's economy and agriculture.",
                "Scotland has more than 790 islands, including the famous Isle of Skye, known for its rugged landscapes, medieval castles, and dramatic coastline.",
                "Japan has over 6,800 islands, but approximately 97% of the land area is concentrated on the four largest islands: Honshu, Hokkaido, Kyushu, and Shikoku.",
                "Mexico City is built on top of the ruins of the ancient Aztec capital of Tenochtitlan. Today, many of the city's streets follow the same layout as the ancient city's canals.",
                "Germany is home to the world's largest beer festival, Oktoberfest, which takes place annually in Munich. It attracts millions of visitors from around the world."
        };
        initialize(questions, options, correctAnswers, hints, imagePaths, funFacts);
    }

    private void initializeFlags() {
        String[] questions = {
                "What is the flag in the image?",
                "What is the flag in the image?",
                "What is the flag in the image?",
                "What is the flag in the image?",
                "What is the flag in the image?"
        };
        String[][] options = {
                {"A) France", "B) Italy", "C) Russia", "D) Netherlands"},
                {"A) South Korea", "B) Bangladesh", "C) Japan", "D) Taiwan"},
                {"A) Vietnam", "B) China", "C) North Korea", "D) Cambodia"},
                {"A) Monaco", "B) Austria", "C) Poland", "D) Indonesia"},
                {"A) Australia", "B) New Zealand", "C) Fiji", "D) Samoa"}
        };
        String[] correctAnswers = {"A) France", "C) Japan", "A) Vietnam", "C) Poland", "B) New Zealand"};
        String[] hints = {
                "This country is famous for its cuisine, including wine and cheese, and it's home to a world-renowned Tower.",
                "This country is known for its rich samurai history, cherry blossoms, and being a leading innovator in technology.",
                "Known for its breathtaking landscapes including Halong Bay, this country is also famous for a special soup called Pho.",
                "This country is the birthplace of the famous composer Frédéric Chopin and has a dish well-loved around the world, pierogi.",
                "Famous for its indigenous Maori culture and stunning landscapes that featured prominently in the 'Lord of the Rings' movies."
        };
        String[] imagePaths = {"path1", "path2", "path3", "path4", "path5"};
        String[] funFacts = {
                "The Eiffel Tower was originally intended to be a temporary installation for the 1889 World's Fair, but it was saved from demolition and has since become one of the most iconic landmarks in the world.",
                "Japan has over 6,800 islands, but approximately 97% of the land area is concentrated on the four largest islands: Honshu, Hokkaido, Kyushu, and Shikoku.",
                "The Vietnamese city of Hoi An is known for its beautifully preserved Ancient Town, a UNESCO World Heritage Site, which reflects the blend of indigenous and foreign influences that have shaped the city's culture.",
                "Poland is home to the Wieliczka Salt Mine, a UNESCO World Heritage Site famous for its intricate underground sculptures, chapels, and saline lakes, all carved out of salt.",
                "New Zealand is home to the only alpine parrot in the world, the kea, known for its intelligence and curiosity. It inhabits the mountainous regions of the South Island."
        };
        initialize(questions, options, correctAnswers, hints, imagePaths, funFacts);
    }

    public static void main(String[] args) {
        ThemeLevelData landmarksQuiz = new ThemeLevelData(1);
        ThemeLevelData traditionalClothingQuiz = new ThemeLevelData(2);
        ThemeLevelData flagsQuiz = new ThemeLevelData(3);

        displayQuiz("Theme: Landmarks", landmarksQuiz);
        displayQuiz("Theme: Traditional Clothing", traditionalClothingQuiz);
        displayQuiz("Theme: Flags", flagsQuiz);
    }

    private static void displayQuiz(String theme, ThemeLevelData quiz) {
        System.out.println(theme);

        for (int i = 0; i < quiz.questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + quiz.questions[i]);
            for (String option : quiz.options[i]) {
                System.out.println(option);
            }
            System.out.println("Hint: " + quiz.hints[i]);
            System.out.println("Correct Answer: " + quiz.correctAnswers[i]);
            System.out.println();
        }
    }
}
