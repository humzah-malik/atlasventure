public class levelData {
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

    public levelData(int level)
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
        else if (level ==4)
        {
           initalize(options4, correctAnswers4, hints4, imagePaths4, funFacts4);

        }
        else if (level ==5)
        {
            initalize(options5, correctAnswers5, hints5, imagePaths5, funFacts5);

        }

    }
    
    ////////////////////Q1
    String[][] options1 = {
            {"Lyon", "Paris", "Marbella", "Moscow"},
            {"London", "Sweden", "Vancouver", "New Jersey"},
            {"New York", "Sydney", "Melbourne", "Las Vegas"},
            {"Amsterdam", "Adelaide", "Rio de Janeiro", "Sydney"},
            {"Calgary", "Toronto", "Montreal", "Vancouver"}
    };
    String[] correctAnswers1 = {"Paris", "London", "New York", "Sydney", "Toronto"};
    
    String[] hints1 = {
            "This city is known as the 'City of Light' and is home to the Eiffel Tower.",
            "This city is famous for its historic landmarks like Big Ben and the London Eye.",
            "Known as 'The Big Apple,' this city is famous for Times Square and Central Park.",
            "This city is known for its iconic Opera House and Harbour Bridge.",
            "This city is famous for its lively entertainment, vibrant neighbourhoods like Kensington Market and Chinatown, and its world-renowned film festival."
    };
    
    String[] imagePaths1 = {"/images/Paris.jpg", "/images/London.jpg", "/images/NewYork.jpg", "/images/Sydney.jpg", "/images/Toronto.jpg"};
    
    String [] funFacts1 = {
            "Paris was originally a Roman city called \"Lutetia.\"",
            "London buses were not always red. Before 1907, different routes had different colored buses.",
            "More than 800 languages are spoken in New York City, making it the most linguistically diverse city in the world.",
            "Sydney's Bondi Beach gets its name from an Aboriginal word meaning \"water breaking over rocks.\"",
            "Toronto's Yonge Street was once considered the longest street in the world."
    };

    ////////////////////Q2
    String[][] options2 = {
            {"Tokyo(Disneyland)", "Orlando(DisneyLand)", "Paris(Disneyland)", "California(Disneyland"},
            {"Agra,India", "Karachi,Pakistan", "Islamabad,Pakistan", "Mumbai,India",},
            {"Kiev", "Prague", "Stockholm", "Moscow"},
            {"Venice", "Bordeux", "Sicily", "Marbella"},
            {"Washington", "Miami", "Los Angeles", "Atlanta"}
    };
    String[] correctAnswers2 = {"Orlando(DisneyLand)", "Agra,India", "Moscow", "Venice", "Los Angeles"};
    
    String[] hints2 = {
            "This city is often referred to as the \"Theme Park Capital of the World\" due to its abundance of amusement parks.",
            "This city is home to one of the most iconic symbols of love and is an architectural wonder, known for its intricate white marble design and serene gardens.",
            "This city is famous for its architecture and historic landmarks like the Kremlin and St. Basil's Cathedral with modern structures like the International Business Center.",
            "This city is renowned for its unique transportation system of canals, earning it the nickname The Floating City.",
            "This city is home to the Griffith Observatory, where visitors can observe celestial phenomena such as eclipses, meteor showers, etc, as well as the Getty Center."
    };
    
    
    String[] imagePaths2 = {"/images/OrlandoDis.jpg", "/images/TajMahal.jpg", "/images/Moscow.jpg", "/images/Venice.jpg", "/images/Los.jpg"};
    
    String [] funFacts2 = {
            "Rome is home to the smallest country in the world, Vatican City, which is entirely surrounded by the city itself.",
            "Cairo is home to the oldest and largest film industry in the Arab world, commonly referred to as \"Egyptian cinema.\" It has a rich history dating back to the early 20th century and has produced many iconic films like The Mummy.",
            "The Harbor of Rio de Janeiro is the world's largest natural bay, containing more water than any other bay in the world.",
            "The iconic Levi’s jeans were invented in San Francisco by Levi Strauss. These jeans were originally designed for Gold Rush miners, they quickly became a fashion sensation.",
            "Tokyo has more vending machines per capita than any other city in the world? It's estimated that there's roughly one vending machine for every 23 people! These machines aren't just for drinks either; you can find vending machines selling everything from hot meals and fresh fruit to umbrellas and even clothing"
    };

    ////////////////////Q3
    String[][] options3 = {
            {"Rome", "Sicily", "Turin", "Venice"},
            {"Alexandria", "Cairo", "Marrakech", "Riyadh"},
            {"Brasilia", "Rosario", "Rio De Janeiro", "São Paulo"},
            {"San Antonio", "Los Angeles", "San Diego", "San Fransisco"},
            {"Kyoto", "Tokyo", "Hong Kong", "Beijing"}
    };
    String[] correctAnswers3 = {"Rome", "Cairo", "Rio De Janeiro", "San Fransisco", "Tokyo"};
    
    String[] hints3 = {
            "This city is often called the 'Eternal City' and is renowned for its rich history, ancient ruins like the Colosseum as well as its iconic landmarks such as the Vatican city.",
            "This city is home to one of the seven wonders of the ancient world, and the sphinx. It's situated along the Nile River and is known for its traditional markets, vibrant culture, and millennia-old history.",
            "This city is renowned for its iconic landmarks such as the Christ the Redeemer statue and Copacabana Beach. It's also famous for its carnival celebrations, samba music, and lively street parties.",
            "This city is known for its steep hills, near Alcatraz prison, its tech harbour, and a rich history shaped by the Gold Rush era.",
            "This city is known for its efficient and extensive public transportation system, including the famous Shinkansen (bullet train)."
    };
    
    String[] imagePaths3 = {"/images/Rome.jpg", "/images/Cairo.jpg", "/images/Rio.jpg", "/images/Sans.jpg", "/images/Tokyo.jpg"};
    
    String [] funFacts3 = {
            "NASA's Kennedy Space Center, where historic space missions were launched, is located just an hour's drive from Orlando.",
            "The pillars surrounding the Taj Mahal are slightly tilted outwards on purpose so that in the event of an earthquake the pillars would fall away from the tomb without causing any damage to the monument.",
            "Moscow's Metro system is not just a transportation network but also a showcase of stunning architecture and art. Many of its stations are adorned with intricate mosaics, sculptures, and chandeliers.",
            "Venice is built on 118 small islands and has over 400 bridges connecting its various parts.",
            "The Hollywood Walk of Fame, which honors over 2,600 figures from the entertainment industry, consists of more than 18 miles of terrazzo and brass stars embedded in the sidewalks."
    };

    ////////////////////Q4

    String[][] options4 = {
            {"Grand Canyon", "Yosemite Valley", "Zion National Park", "Bryce Canyon"},
            {"Victoria Falls", "Iguaza Falls", "Niagara Falls", "Angel Falls"},
            {"Ankara", "Istanbul", "Casablanca", "Athens"},
            {"Petra", "Machu Picchu", "Teotihuacan", "Acropolis of Athens"},
            {"Malta", "Sicily", "Gibraltar", "Corsica"}
    };

    String[] correctAnswers4 = {"Grand Canyon", "Iguaza Falls", "Istanbul", "Machu Picchu", "Gibraltar"};

    String[] hints4 = {
            "This natural wonder is carved by the Colorado River and it although the canyon is large, it is still not the deepest canyon in the world.",
            "This landmark is not just one massive waterfall, but a chain of hundreds of waterfalls nearly 3 kilometers in length in Argentina.",
            "This city straddles two continents and has served as the capital of three great empires throughout history.",
            "This place is often referred to as the 'Lost City of the Incas'. It's located high in the Andes Mountains of Peru, above the Urubamba River valley.",
            "This territory is a British Overseas Territory and is strategically located at the entrance to the Mediterranean Sea, making it a key naval and military base throughout history."
    };

    String[] imagePaths4 = {"/images/GrandCanyon.jpg", "/images/IguazaFalls.jpg", "/images/Istanbul.jpg", "/images/MachuPicchu.jpg", "/images/Gibraltar.jpg"};

    String [] funFacts4 = {
            "The Grand Canyon is not only grand in its landscapes but also in its biodiversity, with over 373 bird species, 91 mammal species, and a total of more than 8000 species that call it home.",
            "The Iguazu Falls, formed by the Iguazu River, is actually a UNESCO World Heritage Site. It's also recognized not only for its habitat of diverse flora and fauna, including rare and endangered species such as the jaguar and the giant otter.",
            "Istanbul is home to the Basilica Cistern, an ancient underground water reservoir built during the Byzantine period.",
            "Machu Picchu is situated at an elevation of approximately 2,430 meters (7,970 feet) above sea level, offering stunning panoramic views of the surrounding Andean mountains.",
            "Gibraltar is home to a population of Barbary macaques, the only wild monkey population in Europe. Legend has it that as long as the monkeys inhabit Gibraltar, the territory will remain under British rule."
    };

    //////////////////// Q5
    String[][] options5 = {
        {"Kashmir Valley", "Hunza Valley", "Napa Valley", "Kathmandu Valley"},
        {"Giza", "Petra", "Luxor", "Babylon"},
        {"Barcelona", "Seville", "Madrid", "Lisbon"},
        {"Budapest", "Vienna", "Prague", "Warsaw"},
        {"Nairobi", "Johannesburg", "Dubai", "Cape Town"}
};

    String[] correctAnswers5 = {"Hunza Valley", "Petra", "Barcelona", "Prague", "Cape Town"};

    String[] hints5 = {
            "This valley is situated in the Gilgit-Baltistan region of northern Pakistan and is famous for its picturesque scenery, including towering peaks like Rakaposhi and Ultar Sar.",
            "This archaeological site is renowned for its ancient rock-cut architecture and its role as the capital of the Nabatean Kingdom.",
            "This city is known for its unique architecture, including the famous Sagrada Familia and Park Güell.",
            "This city is renowned for its delicious cuisine, including traditional dishes such as goulash, dumplings, and hearty Czech beers.",
            "This city is located at the southern tip of the African continent and is renowned for its vibrant cultural scene, including music, art, and literature."
    };

    String[] imagePaths5 = {"/images/Hunza.jpg", "/images/Petra.jpg", "/images/Bar.jpg", "/images/Prague.jpg", "/images/Cape.jpg"};

    String [] funFacts5 = {
            "The Hunza Valley is home to some of the longest-living people in the world, with residents known for their longevity and excellent health. This has led to the valley being dubbed the \"Valley of Longevity.\"",
            "Petra is famously known as the \"Rose City\" due to the pinkish hue of its sandstone cliffs, which change color throughout the day, glowing in shades of red and pink during sunrise and sunset.",
            "Barcelona's iconic Sagrada Familia basilica has been under construction for over 138 years and is still not completed. It's expected to be finished in the early 2030s, making it one of the longest construction projects in history.",
            "Prague is home to the world's oldest operating astronomical clock, known as the Prague Astronomical Clock or the Orloj. Installed in 1410, this intricate timepiece still draws crowds with its hourly show of moving figures and astronomical indicators.",
            "Cape Town is home to one of the most diverse floral kingdoms in the world, known as the Cape Floral Kingdom"
    };

}
