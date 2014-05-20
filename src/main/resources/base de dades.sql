create table users (name varchar(20),password text,email varchar(30),PRIMARY KEY(name));
create table city (ref varchar(5),name varchar(30),country varchar(30),PRIMARY KEY (ref));
create table routes (name varchar(50),description text,fk_ref varchar(5) references city(ref),PRIMARY KEY(name));
create table points (name varchar(50),lat numeric(12,9),lon numeric(12,9),street text, description text, image text, url text,fk_ref varchar(5) references city(ref),PRIMARY KEY(name));
create table valoration (def numeric,fk_route varchar(50) references routes(name),fk_user varchar(20) references users(name),PRIMARY KEY (fk_user,fk_route));
create table comments (def text,fk_route varchar(50) references routes(name),fk_user varchar(20) references users(name),PRIMARY KEY (fk_user,fk_route));
create table relationRP (routeName varchar(50) references routes(name),pointName varchar(50) references points(name),position integer);

insert into users values ('admin', md5('admin'),'admin@admin.es');

insert into city values ('BCNES','Barcelona','Spain');
insert into city values ('MADES','Madrid','Spain');
insert into city values ('LONUK','London','United_Kingdom');

insert into points values (
	'Museu d’Art Contemporani de Barcelona', 
	41.383191300, 
	2.166866800,
	'Plaça dels Àngels, 1',
	'The Barcelona Museum of Contemporary Art is situated in the Plaça dels Àngels, in El Raval, Ciutat Vella, Barcelona, Spain. The museum opened to the public on November 28, 1995. Its current director is Bartomeu Marí (since 2008). Previous directors were Daniel Giralt-Miracle (1988–1994), Miguel Molins (1995–1998), Manuel J. Borja-Villel (1998–2007).', 
	'MACBA.jpg', 
	'http://www.macba.cat/',
	'BCNES');
insert into points values (
	'Museu Picasso',
	41.385216000,
	2.180892700,
	'Carrer Montcada, 15-23',
	'The Museu Picasso, located in Barcelona, Spain, houses one of the most extensive collections of artworks by the 20th-century Spanish artist Pablo Picasso. With more than 3,500 works by the painter, the museum has the most complete collection of works. The museum is housed in five adjoining medieval palaces in Barcelona’s La Ribera and is located on Montcada Street in the (Bank District) of Barcelona.',
	'Museu_Picasso.jpg',
	'http://www.museupicasso.bcn.cat/',
	'BCNES');
insert into points values (
	'Museu Nacional d’Art de Catalunya',
	41.368439900,
	2.153570000,
	'Parc de Montjuïc, s/n',
	'The Museu Nacional d’Art de Catalunya, abbreviated as MNAC, is the national museum of Catalan visual art located in Barcelona, Catalonia, Spain. Situated on Montjuïc hill at the end of Avinguda de la Reina Maria Cristina, near Pl Espanya. The museum is especially notable for its outstanding collection of romanesque church paintings, and for Catalan art and design from the late 19th and early 20th centuries, including modernisme and noucentisme. The Museum is housed in the Palau Nacional, a huge, Italian-style building dating to 1929.',                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	'MNAC.jpg',
	'http://museunacional.cat',
	'BCNES');
insert into points values (
	'Museu de la Xocolata',
	41.387677000,
	2.181664900,
	'Carrer del Comerç, 36',
	'Museu de la Xocolata is a private museum in Barcelona, Catalonia, Spain, owned by the Gremi de Pastisseria de Barcelona (the city pastry-makers guild).',
	'Museu_de_la_Xocolata_de_Barcelona.jpg',
	'http://www.museuxocolata.cat/',
	'BCNES');
insert into points values (
	'Museu del FC Barcelona',
	41.380842400,
	2.122879900,
	'Av.Arístides Maillol, s/n',
	'The FC Barcelona museum was inaugurated on 24 September 1984 under the presidency of Josep Lluís Nuñez. In 2000 the museum was renamed President Nuñez museum under the presidency of his successor, Joan Gaspart. On 15 June 2010 the museum was reopened after a long restructuring. The restructuring saw the museum split in three separate sections with a 3D cinema, audiovisual touch-screen, and information on the history of FC Barcelona.',                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	'Trophies_FCBarcelona_museum.jpg',
	'http://www.fcbarcelona.es/camp-nou/camp-nou-experience',
	'BCNES');
insert into points values (
	'Fundació Antoni Tàpies',
	41.391547000,
	2.163795000,
	'Carrer d’Aragó, 255',
	'The Fundació Antoni Tàpies is a cultural center and museum, located in Carrer d’Aragó, in Barcelona, Catalonia (Spain), dedicated mainly to the life and works of the painter Antoni Tàpies. The Fundació was created in 1984 by the artist Antoni Tàpies to promote the study and knowledge of modern and contemporary art. It combines the organisation of temporary exhibitions, symposia, lectures and film seasons with a range of publications to go with the activities and periodic shows of Antoni Tàpies’ work. The Fundació owns one of the most complete collections of Tàpies’ work, mostly made up of donations by Antoni and Teresa Tàpies.',
	'fundacioTapies.jpg',
	'http://www.fundaciotapies.org/',
	'BCNES');
insert into points values (
	'Centre d’Art Santa Mònica',
	41.377793200,
	2.175954500,
	'La Rambla, 7',
	'Centre d’Art Santa Mònica, sometimes shortened as CASM, is a public museum of contemporary art in Barcelona (Catalonia) opened in 1988. It’s located in the Raval side of Rambla de Santa Mònica (Ciutat Vella district). It has no permanent collection but it hosts a number of travelling expositions of contemporary Spanish and international artists every year. Entrance is free.The building that hosts CASM is a 1626 Renaissance convent that became a monument of national interest in 1984.',
	'Centre_Art_Santa_Monica.jpg',
	'http://www.artssantamonica.cat',
	'BCNES');
insert into points values (
	'Centre de Cultura Contemporània de Barcelona',
	41.383764000,
	2.166495300,
	'Carrer Montalegre, 5',
	'The Centre de Cultura Contemporània de Barcelona is one of the most visited exhibition and arts centres in the city of Barcelona, Spain. Situated in the Raval district, the Centre’s core theme is the city and urban culture. Its success is based on quality, its rather eclectic approach, attention to a broad cross section of publics and the unique way it addresses issues with the aim of linking the academic world with creative processes and citizens in general. The CCCB organizes and produces exhibitions, debates, festivals and concerts; programmes film cycles, courses and lectures; encourages creation using new technologies and languages, explores and promotes the ongoing fusion of languages and different genres, and takes in-house productions to other national and international arts centres, museums and institutions.',
	'CCCB_20070408.jpg',
	'http://www.cccb.org',
	'BCNES');
insert into points values (
	'Museu Europeu d’Art Modern',
	41.384946200,
	2.180383300,
	'Carrer de la Barra de Ferro, 5',
	'The European Museum of Modern Art , MEAM, exhibits the finest Contemporary Figurative Art. It is owned by TheFoundation of Arts and Artists, and the purpose is to promote and diffuse Figurative Art of the 20th and 21st Centuries. The Foundation’s claim is to find a new contemporary language without denying tradition by progressing into the new Century. Moreover, the Foundation of Arts and Artists, organizes each year the Figurativas Painting and Sculpture Awards, and with the wesbiteFigurativas en Red opens a window with the artworks of the Contemporary Figurative artists.',
	'museu_de_art_modern.jpg',
	'http://www.meam.es/',
	'BCNES');
insert into points values (
	'Museu de l’Eròtica de Barcelona',
	41.382289800,
	2.172588600,
	'La Rambla, 96',
	'Right in the heart of one of the most beautiful and visited cities in the world, the Erotic Museum of Barcelona is, since its opening in 1997, one of the most emblematic spots of the count city. The museum is located at La Rambla, opposite La Boqueria, one of the most attractive and known markets in the world. The sexy world of the Hindu Kama Sutra, erotic art banned in Japan, the origins of Spanish pornographic cinema, the history of erotic art through the eyes of the great masters of painting and the most astonishing sexual records...',
	'museo-erotico-de-barcelona.jpg',
	'http://www.erotica-museum.com/',
	'BCNES');
insert into points values (
	'Museu de Cera de Barcelona',
	41.377284500,
	2.177398900, 
	'Passatge de la Banca, 7',
	'In the Museu de Cera affect the more than 360 figures of kings, murderers, popes and other famous personalities almost lifelike as the great model, the waxworks Madame Tussauds in London. The focus of the wax figures Cabinet in Barcelona is on personalities of the Spanish-Catalan history and the region, but also many internationally known figures are here.',
	'museo_cera_barcelona_small.jpg',
	'http://www.museocerabcn.com/',
	'BCNES');
insert into points values (
	'Museu d’idees i invents de Barcelona',
	41.382210400,
	2.178085500,
	'Carrer de la Ciutat, 7',
	'The miba houses a wide variety of content, encompassing the fascinating spectrum of invention and creativity. Each space fulfils a specific role, with the aim of creating an interesting experience for all those involved in the creative and business processes as well as the general public. The miba has three sections: Limitless Society, Reflectionarium, Corner of the Absurd.',
	'miba.jpg',
	'http://www.mibamuseum.com/',
	'BCNES');
insert into points values (
	'Museu Blau',
	41.410789000,
	2.220654000,
	'Carrer de Leonardo Da Vinci, 4',
	'The Natural History Museum of Barcelona consists of four centres located in three strategic parts of the city: Ciutadella Park, Montjuïc Mountain and the Forum. The Forum houses the Museu Blau (the Blue Museum), a centre with excellent modern facilities specifically designed for public use (exhibitions, workshops, conferences, media libraries, etc.).',
	'Museu_Blau.jpg',
	'http://www.museuciencies.cat/',
	'BCNES');
insert into points values (
	'Sagrada Familia',
	41.403570700,
	2.174472199,
	'Carrer de Mallorca, 401',
	'The Basílica i Temple Expiatori de la Sagrada Família, is a large Roman Catholic church in Barcelona, Spain, designed by Catalan architect Antoni Gaudí (1852–1926). Although incomplete, the church is a UNESCO World Heritage Site, and in November 2010 Pope Benedict XVI consecrated and proclaimed it a minor basilica, as distinct from a cathedral which must be the seat of a bishop. Construction of Sagrada Família had commenced in 1882, Gaudí became involved in 1883, taking over the project and transforming it with his architectural and engineering style, combining Gothic and curvilinear Art Nouveau forms. Gaudí devoted his last years to the project, and at the time of his death at age 73 in 1926 less than a quarter of the project was complete. Sagrada Família’s construction progressed slowly, as it relied on private donations and was interrupted by the Spanish Civil War, only to resume intermittent progress in the 1950s. Construction passed the midpoint in 2010 with some of the project’s greatest challenges remaining and an anticipated completion date of 2026, the centenary of Gaudí’s death.',
	'Sagrada_Familia.jpg',
	'www.sagradafamilia.cat/‎',
	'BCNES');
insert into points values (
	'Park Güell',
	41.414494800,
	2.152694500,
	'Carre d’Olot, s/n',
	'When Park Güell began to be built in 1900 Barcelona was a modern and cosmopolitan metropolis whose economy was based on the strength of its industry and which had over half a million inhabitants. Its walls had been knocked down nearly half a century earlier and the new city, the Eixample planned by engineer Ildefons Cerdà, had grown spectacularly from 1860 onwards, in what was the largest 19th century city development project in Europe.',
	'parkGuell.jpg',
	'http://www.parkguell.cat',
	'BCNES');
insert into points values (
	'Casa Batlló',
	41.391616400,
	2.165013199,
	'Passeig de Gràcia, 43',
	'Casa Batlló, built between 1904 and 1906 in the heart of the city, is the most emblematic work of the brilliant Catalan architect. Gaudí gave Casa Batlló a facade that is original, fantastical and full of imagination. He replaced the original facade with a new composition of stone and glass. He ordered the external walls to be redesigned to give them a wavy shape, which was then plastered with lime mortar and covered with a mosaic of fragments of coloured glass and ceramic discs.',
	'Gaudi-Batllo.jpg',	
	'http://www.casabatllo.es/‎',
	'BCNES');
insert into points values (
	'Casa Milà - La Pedrera',
	41.395380100,
	2.161941399,
	'Carrer de Provença, 261-265',
	'Casa Milà, popularly known as ‘La Pedrera’ (the stone quarry), an ironic allusion to the resemblance of its façade to an open quarry, was constructed between 1906 and 1912 by Antoni Gaudí (1852-1926). For its uniqueness, artistic and heritage value have received major recognition and in 1984 was inscribed on UNESCO World Heritage List, for its exceptional universal value.',
	'Casa_Mila.jpg',
	'http://www.lapedrera.com/',
	'BCNES');
insert into points values (
	'La Catedral de Santa Eulalia de Barcelona',
	41.383962000,
	2.186199099,
	'Pla de la Seu, s/n',
	'The Cathedral of Barcelona is comprised of three naves, but just a single apse and ambulatory. The naves have five sections: that closest to the façade is the longest in order to accommodate the dimensions of the cimborio, which is adjacent to the main entrance.The typical structure used in Catalan Gothic constructions, arranged to permit use of the spaces within the buttresses, allowed rows of secondary chapels to be opened up in the Cathedral. There are two chapels in each section of the naves, encircling the entire basilica.',
	'catedral.jpg',
	'http://www.catedralbcn.org/',
	'BCNES');
insert into points values (
	'Arc de Triomf de Barcelona',
	41.391011100,
	2.180732199,
	'Passeig de Lluís Companys',
	'The Arc de Triomf is an arch in the manner of a memorial or triumphal arch in Barcelona (Catalonia, Spain). It was built as the main access gate for the 1888 Barcelona World Fair by architect Josep Vilaseca i Casanovas. The arch is built in reddish brickwork in the Neo-Mudéjar style. The front frieze contains the stone sculpture Barcelona rep les nacions (Catalan for "Barcelona welcomes the nations") by Josep Reynés. The opposite frieze contains a stone carving entitled Recompensa (Recompense), a work from Josep Llimona’s the earliest period, representing the granting of awards to the participants in the World Exposition.Similar structures, though with other uses or aims, can be found in Paris (France), London (England), Brooklyn (New York, USA) and Bucharest (Romania), among many others.',
	'arc.jpg',
	null,
	'BCNES');
insert into points values (
	'Parc de la Ciutadella',
	41.388916,
	2.183576,
	'Passeig de Picasso, 21',
	'Overflowing with largely centenarian vegetation and very rich in plant species, the Parc de la Ciutadella contains a large diversity of features which make it especially valuable. The monumental waterfall, the buildings constructed in the second half of the nineteenth century and today converted into museums, the lake where visitors can row boats and the paths and numerous sculptures in the park are but a few examples. The Barcelona zoo also stands in the grounds of the Park.',
	'Parc_de_la_Ciutadella.jpg',
	null,
	'BCNES');
insert into points values (
	'Hospital de Sant Pau',
	41.4143085,
	2.174502999,
	'Carrer de Sant Quintí, 89',
	'The Hospital de la Santa Creu i Sant Pau came into being in 1401 with the merging of the six hospitals in the city of Barcelona at that time. Santa Creu, the Hospital of the Holy Cross, as it was called in those days, was right in the centre of the city, in what is now the Raval district, in one of the most important examples of Catalan Civil Gothic architecture. By the late nineteenth century, due to the rapid growth of Barcelona’s population and advances in medicine,the hospital became too small, and it was decided to construct a new building. Thanks to the bequest of the Catalan banker Pau Gil, the first stone of the new hospital, designed by Lluís Domènech i Montaner, was laid on 15 January 1902, though the new facilities would not be opened until 1930. After eighty years of healthcare activity in the Modernista complex, in 2009 the Hospital de la Santa Creu i Sant Pau moved to new premises built in the north-east of the precinct, thus commencing a new era for the historic pavilions of Domènech i Montaner.',
	'Barcelona_Hospital_Sant_Pau.jpg',
	'http://www.santpaubarcelona.org/',
	'BCNES');
insert into points values (
	'Torre Agbar',
	41.4033333,
	2.189444399,
	'Avinguda Diagonal, 211',
	'The Torre Agbar is a 38-story skyscraper / tower located between Avinguda Diagonal and Carrer Badajoz, near Plaça de les Glòries Catalanes, which marks the gateway to the new technological district of Barcelona, Catalonia, Spain. It was designed by French architect Jean Nouvel in association with the Spanish firm b720 Fermin Vazquez Arquitectos and built by Dragados. The Torre Agbar is located in the Poblenou neighbourhood of Barcelona and is named after its owners, the Agbar Group, a holding company whose interests include the Barcelona water company Aigües de Barcelona. The tower measures a total of 50,693 square metres, of which 30,000 are offices, 3,210 technical facilities, 8,132 services, including an auditorium, and 9,132 square metres for parking.',
	'torreAgbar.jpg',
	'http://www.torreagbar.com/',
	'BCNES');
insert into points values (
	'El Parc del Laberint d’Horta',
	41.4398348,
	2.15627530,
	'Passeig dels Castanyers, 1',
	'The Parc del Laberint d’Horta is an historical garden in the Horta-Guinardó district in Barcelona, and the oldest of its kind in the city. Located in the former estate of the Desvalls family, next to the Collserola ridge, the park comprises an 18th-century neoclassical garden and a 19th-century romantic garden.',	
	'Parc_del_Laberint.jpg',
	null,
	'BCNES');
	
insert into points values (
	'Puerta del sol',
	40.4168762,
	-3.703304600000024,
	' ',
	'The Puerta del Sol is a place of Madrid (Spain). Here from 1950 is called Kilometre Zero of the Spanish radial road. The oldest building in the Puerta del Sol is the post office and it highlights the clock tower was built and donated in the XIX century by José Rodríguez de Losada, whose chimes of the 12 hours of December 31 mark the traditional eating of the twelve Grapes and the vast majority of Spaniards.',	
	'sol.jpg',
	null,
	'MADES');
	
insert into points values (
	'London tower',
	51.52147919999999,
	-0.13869429999999738,
	'',
	'Her Majesty Royal Palace and Fortress, more commonly known as the Tower of London, is a historic castle on the north bank of the River Thames in central London. It lies within the London Borough of Tower Hamlets, separated from the eastern edge of the square mile of the City of London by the open space known as Tower Hill.',	
	'london_tower.jpg',
	null,
	'LONUK');
	
insert into points values (
	'Natural history museum',
	51.49671499999999,
	-0.17636719999995876,
	'Exhibition Road',
	'The museum is home to life and earth science specimens comprising some 70 million items within five main collections: botany, entomology, mineralogy, palaeontology and zoology. The museum is a world-renowned centre of research specialising in taxonomy, identification and conservation. Given the age of the institution, many of the collections have great historical as well as scientific value, such as specimens collected by Charles Darwin.',	
	'natural_museum.jpg',
	null,
	'LONUK');
	
insert into points values (
	'British museum',
	51.51885679999999,
	-0.12633440000001883,
	'Passeig dels Castanyers, 1',
	'The British Museum is a museum in London dedicated to human history and culture. Its permanent collection, numbering some 8 million works,is among the largest and most comprehensive in existence and originates from all continents, illustrating and documenting the story of human culture from its beginnings to the present.The British Museum was established in 1753, largely based on the collections of the physician and scientist Sir Hans Sloane. ',	
	'british_museum.jpg',
	null,
	'LONUK');
	
insert into points values (
	'Escola del treball de Barcelona',
	41.389135,
	2.14803000,
	'Carrer del Comte Urgell 187',
	'Escola del treball de Barcelona is a group of modernistic buldings. Many years later was a textile factory built between 1868 to 1869 who was closed in 1889. In 1914 will inaugurate Escola Elemental Treball.',
	'escola_treball.jpg',
	'http://www.escoladeltreball.org',
	'BCNES');
insert into points values (
	'Plaça de Catalunya',
	41.387000,
	2.17007203,
	'',
	'Plaça de Catalunya is considered the center of Barcelona and link the Old Centre of city with new. Plaça Catalunya connect Passeig de Gràcia, Rambla de Catalunya, the Rambla and the Portal de Angel, most touristic streets. Plaça Catalunya has shops, restaurants and banks.',
	'plc_catalunya.jpg',
	null,
	'BCNES');
insert into points values (
	'Museu dali',
	41.3846,
	2.17459,
	'Carrer arcs',
	'Discober this fantastic artist in a singular museum in the center of Barcelona',
	'dali_museum.jpg',
	null,
	'BCNES');
insert into points values (
	'Singular arch',
	41.386,
	2.1721195,
	'Portal de angel',
	'discober fantastic architecture forms in the secret places',
	'singular_arch.jpg',
	null,
	'BCNES');
insert into points values (
	'Generalitat palace',
	41.3833,
	2.1769570,
	'Plaça sant jaume',
	'The Palau de la Generalitat is a historic palace in Barcelona, Catalonia, northern Spain. It houses the offices of the Presidency of the Generalitat de Catalunya. It is one of the few buildings of medieval origin in Europe that still functions as a seat of government and houses the institution that originally built it.',
	'generalitat.jpg',
	null,
	'BCNES');
insert into points values (
	'Plaça Reial',
	41.3798406,
	2.175473,
	'Plaça Reial',
	'discober famous place for enjoying your time',
	'reial_place.jpg',
	null,
	'BCNES');
insert into points values (
	'Colon sculture',
	41.375799,
	2.177762,
	'',
	'the gratest famous sculture of American explorer',
	'colon.jpg',
	null,
	'BCNES');
insert into points values (
	'Maremagnum',
	41.37575,
	2.1824294,
	'Port vell',
	'Is a waterfront harbour in Barcelona, Catalonia, Spain, and part of the Port of Barcelona. It was built as part of an urban renewal program prior to the 1992 Barcelona Olympics. Before this, it was a run-down area of empty warehouses, railroad yards, and factories. 16 million people visit the complex each year.It is now a focal point of the city and tourist attraction, containing the Maremàgnum (a mall containing shops, a multiplex cinema, bars and restaurants)',
	'maremagnum.jpg',
	'www.maremagnum.es',
	'BCNES');
insert into points values (
	'Aquarium',
	41.37685,
	2.184389,
	'Port vell',
	'Is a Europe largest aquarium containing 8000 Fish and 11 sharks contained in 22 basins filled with 6 million litres (1.5 million gallons) of sea water.',
	'aquarium.jpg',
	'www.aquariumbcn.com',
	'BCNES');
insert into points values (
	'Palau de mar',
	41.380952,
	2.185873,
	'Port vell',
	'Is a Europe largest aquarium containing 8000 Fish and 11 sharks contained in 22 basins filled with 6 million litres (1.5 million gallons) of sea water.',
	'palau_mar.jpg',
	null,
	'BCNES');
insert into points values (
	'Barceloneta',
	41.37589,
	2.1908082,
	'Barceloneta',
	'The most famous beach in Barcelona.',
	'barceloneta.jpg',
	null,
	'BCNES');
insert into points values (
	'Olimpic frendship sculture',
	41.388180,
	2.19680067,
	'Salvador espriu',
	'The monument for a voluntears in Olimpic games of Barcelona.',
	'abracada.jpg',
	null,
	'BCNES');
insert into points values (
	'Carles I Park',
	41.3889091,
	2.1935712,
	'Salvador espriu',
	'The monument for a voluntears in Olimpic games of Barcelona.',
	'carlesI_park.jpg',
	null,
	'BCNES');
insert into points values (
	'Barcelona Zoo',
	41.387587,
	2.1917348,
	'',
	'The unique zoo in Barcelona city, The zoo used to be internationally known as the home of Snowflake, the only known albino gorilla, who died in 2003.',
	'zoo.jpg',
	'www.zoobarcelona.cat',
	'BCNES');

insert into points values (
	'Parc de Joan Miró',
	41.377823,
	2.146961,
	'Parc de Joan Miro',
	'This large park with lots of open space is also known as the Parc l’Escorxador (so named because it stands on the site of the old municipal slaughterhouse: escorxador in Catalan) and is used by visitors and locals from Barcelona’s Eixample Esquerra to relax. This great urban “lung”, full of possibilities, is located at the south-west end of the neighbourhood and is the perfect appetiser before you begin exploring the monumental Plaça Espanya.',
	'parc_miro.jpg',
	null,
	'BCNES');

insert into points values (
	'Fundació Joan Miró',
	41.22070,
	2.0935,
	'Parc de Montjuïc',
	'The Foundation holds an exceptionally comprehensive collection of works by Joan Miró.',
	'Fundacio_joan_miro.jpg',
	'http://fundaciomiro-bcn.org/',
	'BCNES');

insert into points values (
	'Font de Canaletes',
	41.385422,
	2.170057,
	'Rambla',
	'The fountain is one of the symbols of Barcelona, a meeting place for locals and visitors alike where people also flock to celebrate the victories of the Catalan team, Futbol Club Barcelona, Barça. The Canaletes Fountain has become one of Barcelona’s most visited landmarks. It also conceals a history that is closely associated with the old town’s water supply.',
	'font_de_Canaletes_a_la_Rambla.jpg',
	null,
	'BCNES');

insert into points values (
	'Teatre del Liceu'
	41.380253,
	2.173469,
	'Rambla, 51.65',
	'Barcelona’s theatre opera house, the Gran Teatre del Liceu, opened in 1847 on the Barcelona’s famous Rambla.  One of the key landmarks of Barcelona, it has been a major centre for culture and the performing arts for over 150 years. ',
	'teatre_liceu.jpeg',
	'http://www.liceubarcelona.cat/',
	'BCNES');

insert into points values (
	'Jardins del Palau de Pedralbes',
	41.387390,
	2.118020,
	'Avinguda Diagonal, 686',
	'Behind a 250-m long wall overflowing with bougainvillea is one of the stateliest gardens in Barcelona: the gardens of the Pedralbes Royal Palace. Revealing both English and French influences, romantic bridges and verdant green areas, the truth is that a trip to this park will transport you to a time when serenity and majesty were determining elements of the landscape.',
	'jardins_pedralbes.jpg',
	null.
	'BCNES');
	
insert into routes values('Imprescindible views','interesting trip for most popular points of interes in Barcelona city. Start your visit in Plaça Catalunya, the center of city and visit de greatest places.','BCNES');
insert into routes values('Museum route','instructing trip for most interesting museum in Barcelona. Start your visit in Museu d’Art Contemporani de Barcelona and discover the culture secrets','BCNES');
insert into routes values('Antoni Gaudi','amazing route for discover the secrets of Antoni Gaudi famous architect!, Start your trip in Plaça de Catalunya and see her gratest hits.','BCNES');
insert into routes values('London tour','visit the imprescindible places for discover this old city.','LONUK');
insert into routes values('Childrens route','visit the imprescindible places for childrens funny day.','BCNES');
 
insert into valoration values(5,'Antoni Gaudi','admin');
insert into valoration values(3,'Museum route','admin');
insert into valoration values(5,'Imprescindible views','admin');
insert into valoration values(5,'Childrens route','admin');
insert into valoration values(5,'London tour','admin');

insert into comments values ('We are a fans of Gaudi only a genius can create this kind of structures','Antoni Gaudi','admin');
insert into comments values ('Oh my good! I feel update my intelligence skills.','Museum route','admin');
insert into comments values ('Amazing you can’t go if you don’t see this places.','Imprescindible views','admin');
insert into comments values ('Incredible and misterious animals!.','Childrens route','admin');
insert into comments values ('Amazing you can’t go if you don’t see this places.','London tour','admin');


insert into relationRP values('Museum route','Museu d’Art Contemporani de Barcelona',1);
insert into relationRP values('Museum route','Museu Picasso',2);
insert into relationRP values('Museum route','Museu Nacional d’Art de Catalunya',3);
insert into relationRP values('Museum route','Museu Blau',4);
insert into relationRP values('Museum route','Museu de la Xocolata',5);

insert into relationRP values('Antoni Gaudi','Plaça de Catalunya',1);
insert into relationRP values('Antoni Gaudi','Casa Milà - La Pedrera',2);
insert into relationRP values('Antoni Gaudi','Casa Batlló',3);
insert into relationRP values('Antoni Gaudi','Park Güell',4);
insert into relationRP values('Antoni Gaudi','Sagrada Familia',5);

insert into relationRP values('Imprescindible views','Plaça de Catalunya',1);
insert into relationRP values('Imprescindible views','Museu dali',2);
insert into relationRP values('Imprescindible views','La Catedral de Santa Eulalia de Barcelona',3);
insert into relationRP values('Imprescindible views','Singular arch',4);
insert into relationRP values('Imprescindible views','Generalitat palace',5);
insert into relationRP values('Imprescindible views','plaça reial',6);
insert into relationRP values('Imprescindible views','Museu de Cera de Barcelona',7);
insert into relationRP values('Imprescindible views','Colon sculture',8);
insert into relationRP values('Imprescindible views','Maremagnum',9);
insert into relationRP values('Imprescindible views','Aquarium',10);
insert into relationRP values('Imprescindible views','Palau de mar',11);
insert into relationRP values('Imprescindible views','Barceloneta',12);

insert into relationRP values('Childrens route','Aquarium',1);
insert into relationRP values('Childrens route','Palau de mar',2);
insert into relationRP values('Childrens route','Barceloneta',3);
insert into relationRP values('Childrens route','Olimpic frendship sculture',4);
insert into relationRP values('Childrens route','Carles I Park',5);
insert into relationRP values('Childrens route','Barcelona Zoo',6);

insert into relationRP values('London tour','London tower',3);
insert into relationRP values('London tour','British museum',2);
insert into relationRP values('London tour','Natural history museum',1);


