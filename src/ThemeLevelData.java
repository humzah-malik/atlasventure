public class ThemeLevelData {
    public void initalize(String [][] options, String [] correctAnswers, String [] hints, String [] imagePaths, String [] funFacts)
    {
        this.options = options;
        this.correctAnswers = correctAnswers;
        this.hints = hints;
        this.imagePaths = imagePaths;
        this.funFacts = funFacts;
    }
    public String [][] options;
    public String [] correctAnswers;
    public String [] hints;
    public String [] imagePaths;
    public String [] funFacts;

    public ThemeLevelData(int level)
    {
        if(level == 1 )
        {
            initalize(options1, correctAnswers1, hints1, imagePaths1, funFacts1);
        }
        else if (level ==2)
        {
            initalize(options2, correctAnswers2, hints2, imagePaths2, funFacts2);

        }
        else if (level ==3)
        {
            initalize(options3, correctAnswers3, hints3, imagePaths3, funFacts3);

        }
    }
    
    ////////////////////Q1
    String[][] options1 = {
            {"London, United Kingdom", "Rome, Italy", "Paris, France", "Berlin, Germany"},
            {"Jordan", "Sweden", "Vancouver", "New Jersey"},
            {"Colombia", "Bolivia", "Peru", "Ecuador"},
            {"Lisbon, Portugal", "Barcelona, Spain", "Buenos Aires, Argentina", "Rio de Janeiro, Brazil"},
            {"Athens, Greece", "Sofia, Bulgaria", "Istanbul, Turkey", "Jerusalem, Palestine"}
    };
    String[] correctAnswers1 = {"Paris, France", "Egypt", "Peru", "Rio de Janeiro, Brazil", "Istanbul, Turkey"};
    
    String[] hints1 = {
            "This city is known as the \"City of Light\" and is renowned for its art, fashion, and culinary delights.",
            "This country is home to one of the world's earliest and longest rivers, a cradle of ancient civilization.",
            "This country is famous for its part of the Amazon rainforest and the Andes Mountains.",
            "This city is famous for its carnival, samba, and stunning beaches like Copacabana.",
            "This city, straddling two continents, was historically known as Byzantium and Constantinople."
    };
    
    String[] imagePaths1 = {"/images/Paris.jpg", "/images/London.jpg", "/images/NewYork.jpg", "/images/Sydney.jpg", "/images/Toronto.jpg"};
    
    String [] funFacts1 = {
            "Gustave Eiffel, the tower's namesake, had an apartment at the top of the Eiffel Tower where he would entertain distinguished guests.",
            "The Sphinx is one of the world's largest and oldest statues, but basic facts about it, such as when it was built and by whom, are still debated.",
            "Machu Picchu was re-discovered by historian Hiram Bingham in 1911 after being covered by the jungle and hidden from the outside world for centuries.",
            "The statue's right arm points to the south Rio de Janeiro and the left to the north zone of the city, blessing the entire city.",
            "The Hagia Sophia has been a cathedral, a mosque, and is now a museum. It was the world's largest cathedral for nearly a thousand years until Seville Cathedral was completed in 1520."
    };

    ////////////////////Q2
    String[][] options2 = {
            {"Pakistan", "Bangladesh", "India", "Nepal"},
            {"Ireland", "Scotland", "Wales", "England",},
            {"China", "Korea", "Thailand", "Japan"},
            {"Spain", "Mexico", "Colombia", "Panama"},
            {"Austria", "Switzerland", "Germany", "Liechtenstein"}
    };
    String[] correctAnswers2 = {"India", "Scotland", "Japan", "Mexico", "Germany"};
    
    String[] hints2 = {
            "This country is not only the world's largest democracy but also famous for its diverse cultures, languages, and the Bollywood film industry.",
            "This garment is from a country known for its unique Highland games, whisky distilleries, and being part of the United Kingdom.",
            "This nation is an island country in East Asia, known for its technological advancements, cherry blossoms, and ancient temples.",
            "This country is celebrated for its vibrant festivals, delicious cuisine like tacos and enchiladas, and ancient Mayan and Aztec ruins.",
            "This European country is recognized for its engineering, Oktoberfest beer celebration, and historical figures like Beethoven and Einstein."
    };
    String[] imagePaths2 = {"/images/OrlandoDis.jpg", "/images/TajMahal.jpg", "/images/Moscow.jpg", "/images/Venice.jpg", "/images/Los.jpg"};
    
    String [] funFacts2 = {
            "The sari, which dates back over 5,000 years, is considered one of the oldest forms of garment in the world still in existence. It has been depicted in ancient Indian statues and paintings and remains a fashion staple for millions of people in the region.",
            "Originally, the kilt was a full-length garment whose upper half could be worn as a cloak draped over the shoulder, or brought up over the head as a hood. The kilt as we know it today evolved from the 'great kilt', a full-body garment that was worn in the 16th century.",
            "The word \"kimono\" literally means \"thing to wear\" (ki \"wear\" and mono \"thing\"). Kimonos are wrapped around the body, always with the left side over the right, except when dressing the dead for burial.",
            "The sombrero has a brim wide enough to cast a shadow over the head, neck, and shoulders of the wearer, protecting them from the harsh sun. This design is not only practical but has also become a symbol of Mexican culture.",
            "Lederhosen were once common workwear across Central Europe due to their robustness. Interestingly, these leather pants are often decorated with embroidery that reflects the region of the wearer, serving both a practical and a socio-cultural identity purpose."
    };

    ////////////////////Q3
    String[][] options3 = {
            {"France", "Italy", "Russia", "Netherlands"},
            {"South Korea", "Bangladesh", "Japan", "Taiwan"},
            {"Vietnam", "China", "North Korea", "Cambodia"},
            {"Monaco", "Austria", "Poland", "Indonesia"},
            {"Australia", "New Zealand", "Fiji", "Samoa"}
    };
    String[] correctAnswers3 = {"France", "Japan", "Vietnam", "Poland", "New Zealand"};
    
    String[] hints3 = {
            "This country is famous for its cuisine, including wine and cheese, and it's home to a world-renowned Tower.",
            "This country is known for its rich samurai history, cherry blossoms, and being a leading innovator in technology.",
            "Known for its breathtaking landscapes including Halong Bay, this country is also famous for a special soup called Pho.",
            "This country is the birthplace of the famous composer Frédéric Chopin and has a dish well-loved around the world, pierogi.",
            "Famous for its indigenous Maori culture and stunning landscapes that featured prominently in the \"Lord of the Rings\" movies."
    };
    String[] imagePaths3 = {"/images/Rome.jpg", "/images/Cairo.jpg", "/images/Rio.jpg", "/images/Sans.jpg", "/images/Tokyo.jpg"};
    
    String [] funFacts3 = {
            "The French flag inspired many other countries' flags, including Italy and Ireland, due to its representation of revolutionary ideals.",
            "The Japanese flag is known as \"Nisshoki\" (sun-mark flag) in Japanese, indicating the country's nickname, the Land of the Rising Sun.",
            "The red background symbolizes the struggle for independence, and the five points of the star represent intellectuals, farmers, workers, businesspeople, and military personnel.",
            "The white eagle has been a symbol of Poland since the 13th century, and it appears on the country's coat of arms as well as its flag.",
            "The four stars on New Zealand's flag represent the Southern Cross constellation, emphasizing the country's location in the Southern Hemisphere."
    };

}
