public class levelData {
    public void initalize(String [][] options, String [] correctAnswers, String [] hints, String [] imagePaths, String [][] funFacts)
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
    public String [][] funFacts;

    public levelData(int level)
    {
        if(level ==1 )
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
    String[][] funFacts1 = {
            {
                    "Lyon is known as the gastronomic capital of France, boasting numerous Michelin-starred restaurants and traditional bouchons.",
                    "The Eiffel Tower, one of the most iconic landmarks in the world, was originally intended to be a temporary installation for the 1889 World's Fair.",
                    "Marbella, located on the southern coast of Spain, enjoys over 320 days of sunshine per year, making it a popular destination for sun-seekers and beach enthusiasts.",
                    "Moscow's metro system is not only efficient for transportation but also serves as an underground art museum, with elaborate stations adorned with mosaics, sculptures, and chandeliers."
            },
            {
                    "The British Museum in London houses over 8 million works of art, making it one of the largest and most comprehensive collections in existence.",
                    "Sweden has a law called Allemansrätten, or 'everyman's right,' which allows people to roam freely in nature, camp on any land (except private gardens), and pick wild berries and flowers.",
                    "Stanley Park in Vancouver is larger than New York City's Central Park and attracts millions of visitors each year with its scenic seawall, beaches, and forested trails.",
                    "New Jersey is known as the 'Diner Capital of the World,' with more diners than any other state."
            },
            {
                    "New York City's iconic yellow taxis aren't just a fashion statement; they're required by law to be painted this color.",
                    "The Sydney Opera House's roof is made up of 1,056,000 tiles.",
                    "Melbourne's tramway network is the largest outside Europe and the fourth largest in the world.",
                    "The Luxor Hotel's light beam, when seen from space, is the brightest man-made light in the world."
            },
            {
                    "Amsterdam is home to the world's only floating flower market, known as the Bloemenmarkt. Located along the Singel canal, this market offers a colorful array of flowers, bulbs, and souvenirs from floating barges and stalls.",
                    "Adelaide is known as the 'City of Churches' because it was founded as a colony with religious freedom, leading to the construction of numerous churches.",
                    "Rio de Janeiro has the largest urban forest in the world, Tijuca National Park. This lush forest covers an area of approximately 32 square kilometers (12 square miles) and is home to diverse flora and fauna, including monkeys, birds, and waterfalls.",
                    "Sydney is home to the world's largest steel arch bridge, the Sydney Harbour Bridge. It took 8 years to build and was completed in 1932."

            },
            {
                    "Calgary is home to the largest outdoor urban pathway and bikeway network in North America. Spanning over 1,000 kilometers (620 miles), the pathway system winds through parks, along rivers, and connects various neighborhoods throughout the city.",
                    "Toronto's CN Tower held the title of the world's tallest freestanding structure for 32 years, from its completion in 1976 until 2007 when it was surpassed by the Burj Khalifa in Dubai.",
                    "Montreal is renowned for its extensive underground city, known as the RESO or RÉSO. This subterranean network spans over 32 kilometers (20 miles) and connects shopping centers, hotels, office buildings, universities, metro stations, and more",
                    "Vancouver is the only city in North America where you can ski and golf on the same day. With its close proximity to the Coast Mountains, which receive ample \n snowfall during the winter months, and its mild climate, golf courses in the city remain open year-round.",


            },

    };

    ////////////////
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
    String[][] funFacts2 = {
            {
                    "Tokyo Disneyland was the first Disney theme park to be built outside of the United States and opened on April 15, 1983. A unique feature of Tokyo Disneyland \n is its \"Pooh's Hunny Hunt,\" a ride that uses a trackless ride system, making each experience slightly different.",
                    "Notably, Walt Disney World Resort in Orlando, Florida, is not just a single park but a massive resort comprising four theme parks. A fascinating fact is that it's \n about the size of San Francisco or two Manhattan islands, making it the largest Disney resort in the world.",
                    "Originally opened as Euro Disney Resort in 1992, Disneyland Paris is the first and only Disney theme park in Europe. A fun fact is that the Sleeping Beauty Castle in Disneyland Paris is unique among Disney Castles because it includes a dragon lair beneath it, where a full-sized animatronic dragon resides.",
                    "Opened in 1955, Disneyland California was the very first Disney theme park. An interesting tidbit is that Disneyland hosts a time capsule, known as the Disneyland Time Capsule, \n which is buried in front of Sleeping Beauty Castle and is scheduled to be opened in the year 2035, on the 80th anniversary of the park."
            },
            {
                    "Agra is home to the Taj Mahal, one of the Seven Wonders of the World. An intriguing fact about the Taj Mahal is that it appears to change color depending on the time of day, from pinkish in the morning, milky white in the evening, and golden when the moon shines",
                    "In Karachi, there is a historic marketplace called the Empress Market situated in the Saddar Town locality and it is named after Queen Victoria",
                    "Islamabad is known for its high standard of living, safety, and abundant greenery. The city is also unique because it has a purpose-built nature reserve, the Margalla Hills National Park, which includes rare species of leopards, deer, birds, and even porcupines.",
                    "Mumbai, formerly known as Bombay, is the financial, commercial, and entertainment capital of India. A fun fact about Mumbai is that it is built on what was once an archipelago of seven islands."
            },
            {
                    "Kiev is home to one of the world's deepest subway stations. Arsenalna station is approximately 105 meters (344 feet) underground, making it an interesting and somewhat unique experience for commuters and tourists alike.",
                    "The Astronomical Clock in Prague, known as the Prague Orloj, is the third-oldest astronomical clock in the world and the oldest one still in operation.",
                    "Stockholm is often called the \"Venice of the North\" because it is built on 14 islands connected by 57 bridges.",
                    "Moscow is home to the largest active orthodox church in the world, the Cathedral of Christ the Saviour. Standing at a total height of 103 meters (338 feet), it was originally built in the 19th century, demolished in 1931, and then reconstructed in the 1990s."
            },
            {
                    "Venice is renowned for its intricate waterways, but a lesser-known fact is that the city is built on a foundation of wooden piles driven into the soft ground of the lagoon. These wooden foundations, made from alder trees, have been petrified by the mineral-rich waters",
                    "Bordeaux is often referred to as the \"Wine Capital of the World.\" The region surrounding the city is home to approximately 10,000 wine-producing châteaux, and Bordeaux wines are considered some of the best and most prestigious in the world.",
                    "Sicily is home to Mount Etna, one of the most active volcanoes in the world. This natural giant is not only a significant geological feature but also enriches the soil around it, making the region especially fertile.",
                    "Marbella is known for its luxurious lifestyle and beautiful beaches, but it also has a historical side that many are unaware of. The city's Old Town, \"Casco Antiguo,\" features narrow, winding streets and is home to buildings that date back to the Renaissance."

            },
            {
                    "Beyond being the capital of the United States, Washington, D.C., has no skyscrapers. This is due to the Height of Buildings Act, which limits buildings' heights to prevent them from overshadowing the monuments and the Capital.",
                    "In Miami, the Miami Beach is surrounded by both the Biscayne National Park and the Everglades National Park. It's the only city in the United States that has two different national parks as part of its borders.",
                    "Los Angeles is home to the iconic Hollywood Sign, which originally read \"Hollywoodland\" when it was erected in 1923. Initially intended as an advertisement for a local real estate development, the sign became a symbol of the entertainment industry and was eventually shortened to \"Hollywood.\"",
                    "Atlanta holds a unique record for being the city with the most streets named \"Peachtree.\" There are over 70 streets in Atlanta with some variation of \"Peachtree\" in their names, reflecting Georgia's reputation as the Peach State.",


            },

    };

//////////////
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
    String[][] funFacts3 = {
            {
                    "Rome is home to the smallest country in the world, Vatican City, which is entirely surrounded by the city itself.",
                    "Sicily is the largest Mediterranean island and is famous for its rich history, ancient ruins, and delicious cuisine.",
                    "Turin is known for its refined architecture and cuisine. The city is also home to the famous Shroud of Turin.",
                    "Venice is renowned for its canals, historic architecture, and artwork. It's also known for the iconic gondolas used for transportation around the city."
            },
            {
                    "Alexandria, founded by Alexander the Great, is known for the Lighthouse of Alexandria, one of the Seven Wonders of the Ancient World.",
                    "Cairo is home to the oldest and largest film industry in the Arab world, commonly referred to as 'Egyptian cinema.'",
                    "Marrakech is famous for its historic medina, a UNESCO World Heritage site, and vibrant markets known as souks.",
                    "Riyadh, the capital of Saudi Arabia, is known for its modern skyline and deep-rooted history dating back to the pre-Islamic era."},
                    {
                            "Brasilia, the capital of Brazil, is known for its unique modernist architecture planned by Oscar Niemeyer.",
                            "Rosario is famous for being the birthplace of many notable Argentinians, including the revolutionary Che Guevara.",
                            "Rio De Janeiro is known for its breathtaking landscapes and landmarks such as Christ the Redeemer.",
                            "São Paulo is one of the largest cities in the world and is known for its diverse cultural offerings and vibrant food scene."
                    },
                    {
                            "San Antonio is known for the Alamo, an 18th-century mission and the site of a famous battle for Texan independence.",
                            "Los Angeles is famous for Hollywood, the heart of the American film industry, and its Mediterranean climate.",
                            "San Diego is known for its beautiful beaches, parks, and warm climate.",
                            "San Francisco is famous for the Golden Gate Bridge, Alcatraz Island, and its historic cable cars."},


            {
                    "Kyoto was the capital of Japan for over a millennium and is known for its classical Buddhist temples, as well as gardens, imperial palaces, Shinto shrines, and traditional wooden houses.",
                    "Tokyo, the capital of Japan, is the world’s most populous metropolis and is known for its unique blend of traditional and futuristic features.",
                    "Hong Kong is known for its impressive skyline, bustling harbor, and vibrant food scene.",
                    "Beijing, the capital city of China, is known for its modern architecture as well as historic sites such as the Great Wall and the Forbidden City.",
                   },


    };

    /////////////////////////// Q4

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

    String[][] funFacts4 = {
            {
                    "The Grand Canyon is not only massive in scale but also hides an ancient history. Fossil evidence found in the canyon suggests that it's around 6 million years old.",
                    "Yosemite Valley boasts one of the world's tallest granite monoliths, El Capitan. Rising approximately 900m from the valley floor, it's a renowned challenge for rock climbers.",
                    "Zion National Park features a unique natural phenomenon known as the Zion Narrows. It's a section of the canyon where the walls narrow to only 20-30 feet apart, while towering up to 1,000 feet high, with the Virgin River flowing through.",
                    "Despite its name, Bryce Canyon isn't actually a canyon; it's a series of natural amphitheaters carved into the edge of a high plateau."
            },
            {
                    "Victoria Falls, located on the border of Zambia and Zimbabw is known locally as \"Mosi-oa-Tunya,\" which translates to \"The Smoke That Thunders,\" due to the immense spray and roar created by the falling water.",
                    "The Iguazu Falls, situated on the border between Argentina and Brazil, is actually a collection of around 275 individual waterfalls, spanning almost 2 miles (3 kilometers). The name \"Iguazu\" means \"big water\" in the indigenous Guarani language.",
                    "Niagara Falls, shared between the United States and Canada, is not only famous for its beauty but also for its impressive power. It has the highest flow rate of any waterfall in North America.",
                    "Angel Falls in Venezuela is the highest uninterrupted waterfall in the world, plunging an astonishing 3,212 feet (979 meters)."},
            {
                    "Ankara, the capital of Turkey, is one of the oldest continuously inhabited cities in the world, with a history dating back at least 3,000 years. It became the capital of Turkey in 1923, replacing Istanbul.",
                    "Istanbul, formerly known as Constantinople, is the only city in the world that straddles two continents, Europe and Asia, separated by the Bosphorus Strait.",
                    "Casablanca, the largest city in Morocco, is home to one of the most iconic movie titles of all time, despite the fact that the classic film \"Casablanca\" was primarily filmed in Hollywood",
                    "Athens is the capital of Greece. It was also at the heart of Ancient Greece, a powerful civilization and empire.",
            },
            {
                    "Petra in Jordan is famously known as the \"Rose City\" due to the pink-hued stone from which it is carved, creating a stunning and unique landscape.",
                    "Machu Picchu, located in Peru, was built in the 15th century by the Inca Empire but remained hidden from the outside world until its rediscovery in 1911.",
                    "Teotihuacan in Mexico is home to the Pyramid of the Sun, one of the largest pyramids in the world, and the Pyramid of the Moon, both built by an ancient Mesoamerican civilization.",
                    "The Acropolis of Athens is not just a single monument but a complex of ancient buildings and structures, including the iconic Parthenon, dedicated to the goddess Athena.",
            },


            {
                    "Malta, a small island nation in the Mediterranean, boasts some of the world's oldest free-standing structures, including the megalithic temples, which predate the Pyramids of Egypt.",
                    "Sicily, the largest island in the Mediterranean Sea, has been a cultural melting pot for centuries, with influences from Greek, Roman, Arab, Norman, and Spanish civilizations, making it a treasure trove of diverse history and architecture.",
                    "Gibraltar, a British Overseas Territory located at the southern tip of the Iberian Peninsula, is home to the only wild population of monkeys in Europe, known as Barbary macaques, which are a popular tourist attraction.",
                    "Corsica is home to some of the most spectacular hiking trails in Europe, including the famous GR20 route, which traverses the rugged mountains of the island from north to south.",
            },


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

    String[][] funFacts5 = {
            {
                    "The Hunza Valley is known for its breathtaking natural beauty and the longevity of its inhabitants, often attributed to their healthy lifestyle and diet.",
                    "Kashmir Valley is often referred to as 'Paradise on Earth' due to its stunning landscapes, which include lush meadows, clear lakes, and high mountains.",
                    "Napa Valley is famous worldwide for its wine production, boasting over 400 wineries that produce some of the finest wines in the world.",
                    "Kathmandu Valley is rich in cultural heritage, home to seven UNESCO World Heritage Sites that highlight its history as a crossroads of ancient civilizations."
            },
            {
                    "Giza is home to the iconic Pyramids and the Sphinx, some of the most magnificent ancient structures in the world.",
                    "Petra, known as the Rose City due to the color of the stone from which it is carved, is an archaeological wonder and a symbol of Jordan.",
                    "Luxor in Egypt is often called the world's greatest open-air museum, housing an incredible amount of ancient Egyptian monuments.",
                    "Babylon was a key kingdom in ancient Mesopotamia, famous for its Hanging Gardens, one of the Seven Wonders of the Ancient World."
            },
            {
                    "Barcelona is celebrated for its artistic heritage, largely influenced by the works of Antoni Gaudí, such as Casa Batlló and La Pedrera.",
                    "Seville is known for its rich Moorish heritage, flamenco dancing, and the majestic Alcázar palace.",
                    "Madrid, the capital of Spain, is famous for its art museums, including the Prado Museum, and its lively atmosphere.",
                    "Lisbon, the coastal capital of Portugal, is known for its hilly, cobblestone streets and the iconic Belem Tower."
            },
            {
                    "Budapest, the capital of Hungary, is known for its historic thermal baths, derived from the city's rich thermal springs.",
                    "Vienna, Austria's capital, offers a unique blend of imperial traditions and stunning modern architecture.",
                    "Prague, the capital of the Czech Republic, is known for its preserved medieval architecture and historic Prague Castle.",
                    "Warsaw, the capital of Poland, has been meticulously rebuilt after WWII, showcasing a mix of modern and historical architecture."
            },
            {
                    "Nairobi, the capital of Kenya, is a vibrant city known for its wildlife parks and as a gateway to safari destinations.",
                    "Johannesburg, South Africa's biggest city, is a hub of art, music, and theater, reflecting the country's diverse cultural landscape.",
                    "Dubai, a city in the United Arab Emirates, is known for its modern architecture, luxury shopping, and vibrant nightlife scene.",
                    "Cape Town is famous for its stunning landscapes, including Table Mountain and Cape Point, and its rich cultural diversity."
            }
    };

}
