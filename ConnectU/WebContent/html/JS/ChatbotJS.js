var you = "Me";
botSays("Thanks for checking out my Simple chatBot.\nMy language knowledge is progressing. I recently learned 20 html tags. 6/11/17 \n\nType !name x where x = yourName to change your name.\nTo chat, click Talk to me or press Enter(pc) or Go(android)\nType help for a hint\n\n\n***")
            // Recognized Speech Patterns for Question Responses

var Hello = ["HI", "HEY", "HOWDY", "HEYA", "HOLA", "HELLO", "SUP", "KONNICHIWA", "ALOHA"]
var Goodbye = ["BYE", "SEE YA", "CYA", "LATER", "ADIOS", "SAYONARA", "SEEYA"]
var Greeting = ["WHAT'S UP", "HOW'S IT GOING", "HOW ARE YOU", "NICE DAY", "GOOD MORNING", "GOOD NIGHT"]
var Name = [ "WHAT IS YOUR NAME", "WHAT'S YOUR NAME", "WHO ARE YOU", "WHAT DO THEY CALL YOU", "COMO TE LLAMAS"]
var Actions = ["HELP", "DRINK", "ABOUT INFS1609", "INFS1609 AVAILABLE","WHAT IS INFS1609", "CODING", "REQUIREMENT FOR INFS1609", "LECTURER IN CHARGE FOR INFS1609", "ABOUT INFS1602", "INFS1602 AVAILABLE", "REQUIREMENT FOR INFS1602", "ABOUT INFS3605"]
var Questions = ["LECTURER IN CHARGE FOR INFS1602", "REQUIREMENT FOR INFS1602", "ABOUT INFS3605", "INFS3605 AVAILABLE", "LECTURER IN CHARGE FOR INFS3605", "REQUIREMENT FOR INFS3605", "DIFFERENCE BETWEEN INFS3634 AND INFS3611",  "SAS SOFTWARE", "HE AVAILABLE"];
var More = ["IS THIS AVAILABLE"]
var HTMLTags1 = ["<P>", "<I>", "<SPAN>", "<DIV>", "<ARTICLE>", "<IFRAME>", "<A>", "<ABBR>","<ADDRESS>","<AUDIO>"];
        // Skip the CMD Line and learn HTML by reading my code!~~ LMAO, here have fun.
var HTMLTags2 = [
"<A>", //    Defines a hyperlink
"<ABBR>", //Defines an abbreviation or an acronym
"<ACRONYM>", //    Not supported in HTML5. Use <abbr> instead. Defines an acronym
"<ADDRESS>", //    Defines contact information for the author/owner of a document
"<APPLET>", //    Not supported in HTML5. Use <embed> or <object> instead. Defines an embedded applet
"<AREA>", //    Defines an area inside an image-map
"<ARTICLE>", //    Defines an article
"<ASIDE>", //    Defines content aside from the page content
"<AUDIO>", //    Defines sound content
"<B>" // Defines bold text
]
var HTMLTags3 = [
"<BASE>", // Specifies the base URL/target for all relative URLs in a document
"<BASEFONT>", //    Not supported in HTML5. Use CSS instead. Specifies a default color, size, and font for all text in a document
"<BDI>",    // Isolates a part of text that might be formatted in a different direction from other text outside it
"<BDO>",    //Overrides the current text direction
"<BIG>",    //Not supported in HTML5. Use CSS instead. Defines big text
"<BLOCKQUOTE>", //    Defines a section that is quoted from another source
"<BODY>",    //Defines the document's body
"<BR>",    //Defines a single line break
"<BUTTON>",    //Defines a clickable button
"<CANVAS>"    //Used to draw graphics, on the fly, via scripting (usually JavaScript)
]
var HTMLTags4 = [
"<CAPTION>",    //Defines a table caption
"<CENTER>", //    Not supported in HTML5. Use CSS instead. Defines centered text
"<CITE>", //Defines the title of a work
"<CODE>",    //Defines a piece of computer code
"<COL>",    //Specifies column properties for each column within a <colgroup> element
"<COLGROUP>",    //Specifies a group of one or more columns in a table for formatting
"<DATALIST>",    //Specifies a list of pre-defined options for input controls
"<DD>",    //Defines a description/value of a term in a description list
"<DEL>",    //Defines text that has been deleted from a document
"<DETAILS>",    //Defines additional details that the user can view or hide
"<DFN>" //    Represents the defining instance of a term
]
var colors = ["BLUE", "RED", "GREEN", "YELLOW", "WHITE", "BLACK", "SILVER", "GRAY" ];
var Else = true;
var questions = [colors, HTMLTags4, HTMLTags3, HTMLTags2, HTMLTags1, Hello, Goodbye, Greeting, Name, Actions, Questions];


var reactions=[BotHello, BotGoodbye,BotGreeting];
var BotHello = ["HI", "HEY", "HOWDY", "HEYA", "HOLA", "HELLO", "SUP", "KONNICHIWA", "ALOHA"]
var BotGoodbye = ["BYE", "SEE YA", "CYA", "LATER", "ADIOS", "SAYONARA", "SEEYA"]
var BotGreeting = ["WHAT'S UP", "HOW'S IT GOING", "HOW ARE YOU", "NICE TO SEE YOU", "GOOD MORNING", "WELCOME"]
var BotPleasant = ["Thanks.", "Good job.", "Cool.", "I see.", "Anyway.", "right-o."]

function answer(x) {
    var botOut = bot.value;
    document.getElementsByTagName("textarea")[0] = bot
    //RESPONSES//

                document.getElementsByTagName("input")[0].value = ""
                if (x.charAt(0).includes("!") === false){
                youSay(x); bot.scrollTop = bot.scrollHeight;
                }
                question = x.toUpperCase()
                for (i = 0; i < 10; i++) {
            /*          EMPTY RESPONSE          */
                if (question === "" || null) {
                    setTimeout( function() { botSays("\nBot : What? You shy?"); bot.scrollTop = bot.scrollHeight;}, 600);
                return; }
                /*          COMMAND MENU RESPONSES         */
                else if (question === "!MENU" ) {
                botSays("\n\n**Commands are !Name yourName, !Bgcolor backgroundColor, !Text textColor, !Menu, !Secrets, !Tutorial, !Botsay textSays, and !Me textDoes,. Play around."); bot.scrollTop = bot.scrollHeight;
                return;
                }else if (question.slice(0,9).includes("!BGCOLOR ") ) {
                    botSays("\n\n**Changed the background color to " + x.slice(9) ); bot.scrollTop = bot.scrollHeight; bot.style.backgroundColor = x.slice(9);
                return;
                } else if (question.slice(0,6).includes("!TEXT ") ) {
                    botSays("\n\n**Changed the text color to " + x.slice(6) ); bot.scrollTop = bot.scrollHeight; bot.style.color = x.slice(6);
                return;
                } else if (question.slice(0,6).includes("!NAME") ) {
                    you = x.slice(6);
                    botSays("\n\n**It's nice to meet you, " + you); bot.scrollTop = bot.scrollHeight;
                return;
                } else if (question.slice(0,9).includes("!SECRETS") ) {
                    botSays("\n\n**What? I don't have any secrets. I've got nothing to hide."); bot.scrollTop = bot.scrollHeight;
                return;
                }
                else if (question.slice(0,10).includes("!TUTORIAL") ) {
                    botSays("\n\n**What? I don't have a tutorial. Read my code, I'm not going to explain myself."); bot.scrollTop = bot.scrollHeight;
                return;
                }
                else if (question.slice(0,10).includes("!BOTSAY") ) {
                    botSays("\nBot : " + x.slice(8)); bot.scrollTop = bot.scrollHeight;
                return;
                } else if (question.slice(0,4).includes("!ME") ) {
                    youDo(x.slice(4)); bot.scrollTop = bot.scrollHeight;
                return;
                }
 /* Questions, Answers and Responses */
                if (question.includes(Goodbye[i])) {
                    Else = false;
                    setTimeout(botSays, 600, "\
                                 Bot : Godspeed. Leave an upvote?")
                } else if (question.includes(Name[i])) {
                    Else = false; setTimeout(botSays, 600, "\nBot : My name is BotOne. You can call me tonE.")
                } else if ( question.includes(HTMLTags1[i]) ) {
                    /*HTML Tag Definitions Courtesy of W3Schools.com*/
                    Else = false; if (HTMLTags1[i] === "<P>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<p>' Defines a paragraph.") } else if (HTMLTags1[i] === "<I>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<i>' Defines a part of text in an alternate voice or mood. Italics.") } else if (HTMLTags1[i] === "<SPAN>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<Span>' Defines a section in a document.") } else if (HTMLTags1[i] === "<A>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<Span>' Defines a section in a document.") }
                } else if ( question.includes(HTMLTags2[i]) ) {
                    /*HTML Tag Definitions Courtesy of W3Schools.com*/
                    Else = false; if (HTMLTags2[i] === "<ABBR>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<abbr>' Defines an abbreviation or acronym.") } else if (HTMLTags2[i] === "<ACRONYM>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<acronym>' Not supported in HTML5, use '<abbr>' instead.") } else if (HTMLTags2[i] === "<ADDRESS>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<address>' Defines contact information for the author/owner of a document.") } else if (HTMLTags2[i] === "<APPLET>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<applet>' Not supported in HTML5, use '<embed>' or '<object>' instead.") }else if (HTMLTags2[i] === "<AREA>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<area>' Defines an area inside an image map") } else if (HTMLTags2[i] === "<ARTICLE>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<article>' Defines an article.") } else if (HTMLTags2[i] === "<ASIDE>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<aside>' Defines content aside from the page content.") }  else if (HTMLTags2[i] === "<AUDIO>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<audio>' Defines sound content.") } else if (HTMLTags2[i] === "<B>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<B>' Defines bold text.") }
                } else if ( question.includes(HTMLTags3[i]) ) {
                    Else = false;
                    if (HTMLTags3[i] === "<BASE>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<base>' Specifies the base URL/target for all relative URLs in a document") } else if (HTMLTags3[i] === "<BASEFONT>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<basefont>' Not supported in HTML5. Use CSS instead.  Specifies a default color, size, and font for all text in a document. ") } else if (HTMLTags3[i] === "<BDI>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<bdi>' Isolates a part of text that might be formatted in a different direction from other text outside it. ") } else if (HTMLTags3[i] === "<BDO>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<bdo>' Overrides the current text direction. ") } else if (HTMLTags3[i] === "<BIG>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<big>' Not supported in HTML5, use CSS instead. Defines big text. ") } else if (HTMLTags3[i] === "<BLOCKQUOTE>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<blockquote>' Defines a section that is quoted from another source. ") } else if (HTMLTags3[i] === "<BODY>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<body>' Defines a document's body. ") } else if (HTMLTags3[i] === "<BR>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<br>' Defines a single line break. ") } else if (HTMLTags3[i] === "<BUTTON>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<button>' Defines a clickable button. ") } else if (HTMLTags3[i] === "<CANVAS>" ) { setTimeout(botSays, 600, "\nBot : The HTML tag '<canvas>' Used to draw graphics, on the fly, via scripting. Usually Javascript. ") }

                /*} else if ( question.includes(HTMLTags4[i]) ) {

                } else if ( question.includes(HTMLTags5[i]) ) {

                } else if ( question.includes(HTMLTags6[i]) ) {    */
                /*} else if ( question.includes(HTMLTags7[i]) ) {

                } else if ( question.includes(HTMLTags8[i]) ) {

                } else if ( question.includes(HTMLTags9[i]) ) {    */



                }
                else if (question.includes(Actions[i])) {
                    Else = false; if (question.includes("ABOUT INFS1609")) { setTimeout(botSays, 600, "\nBot : What would you like to find out about Introductory Programming?") } 
                    if (question.includes("INFS1609 AVAILABLE")) { setTimeout(botSays, 600, "\nBot : INFS1609 is available in Term 1 and 3") } 
                    if (question.includes("WHAT IS INFS1609")) { setTimeout(botSays, 600, "\nBot : INFS1609 is a super hands on, fun coding course! This is a foundational (Level 1) Information Systems course that introduces students to application programming.") }
                    if (question.includes("CODING")) { setTimeout(botSays, 600, "\nBot : Coding in Java! It's object-oriented programming, like the objects and entities around us!") }
                    if (question.includes("REQUIREMENT FOR INFS1609")) { setTimeout(botSays, 600, "\nBot : There are no requirements and prerequisites for Infs1609 :) ") }  
                    if (question.includes("LECTURER IN CHARGE FOR INFS1609")) { setTimeout(botSays, 900, "\nBot :  Dr Yenni Tim. You will be able to find her at Level 2 West Wing of the Quad on Mondays 4-6PM  ") }
                  
                    if (question.includes("ABOUT INFS1602")) { setTimeout(botSays, 900, "\nBot :  Digital Transformation in Business (INFS1602) is a foundational course that introduces students to the application of Information Systems (IS) in business and society. It provides the ability to evaluate the value of technology to businesses. Super exciting.") }
                    if (question.includes("INFS1602 AVAILABLE")) { setTimeout(botSays, 600, "\nBot : INFS1602 is available in Term 1, 2 and 3.  ") }  
        
                } else if (question.includes(Questions[i])) {
                 Else = false; if (question.includes("LECTURER IN CHARGE FOR INFS1602")) { setTimeout(botSays, 600, "\nBot : The lecturer in charge is Ms Chona Ryan. Her office is in QUAD 2107A and is available on Tuesdays & Wednesdays 9.30 am to 11 AM ") }
                 if (question.includes("REQUIREMENT FOR INFS1602")) { setTimeout(botSays, 600, "\nBot : There are no requirements and prerequisites for Infs1602 :) ") }
                 if (question.includes("ABOUT INFS3605")) { setTimeout(botSays, 900, "\nBot :  Information Systems Innovation & Transformation focuses on the implementation phase of the development of information systems. It involves working in a team to implement your solution and allows you to understand more about an agile approach. ") }
                 if (question.includes("INFS3605 AVAILABLE")) { setTimeout(botSays, 600, "\nBot : INFS3605 is available in Term 1 and 2 ) ") }  
                 if (question.includes("LECTURER IN CHARGE FOR INFS3605")) { setTimeout(botSays, 600, "\nBot : The head lecture is Dr Michael C. Cahalane. He is available on Mondays from 1 to 2 PM at Quad Room 2113 ") }  
                 if (question.includes("HE AVAILABLE")) { setTimeout(botSays, 600, "\nBot : He is available on Mondays from 1 to 2 PM at Quad Room 2113 ") }  
                 if (question.includes("REQUIREMENT FOR INFS3605")) { setTimeout(botSays, 600, "\nBot : INFS3634 or INFS3611 AND completion of 72 UOC are prerequisites for INFS3605" )  }
				if (question.includes("DIFFERENCE BETWEEN INFS3634 AND INFS3611")) { setTimeout(botSays, 600, "\nBot : Mobile Applications Development (INFS3634) is a mobile programming course using Android platform. However, INFS3611 is no longer available. ")  }
                 if (question.includes("SAS SOFTWARE")) { setTimeout(botSays, 600, "\nBot : Social Media and Analytics (INFS3830) is a course you can take that provides hands-on experience using SAS text mining software. You will learn the purpose, function and design of social media platforms and understand the benefits and drawbacks. " )  } 
               
                }
                else if (question.includes (More[i])){
                	Else = false;  if (question.includes("IS THIS AVAILABLE")) { setTimeout(botSays, 600, "\nBot : This course is available in Term 1 only :) ") } 
                }
                   //DIFFERENCE BETWEEN INFS3634 AND INFS3611
                    
                    
                 
//                else if (question.includes(Actions[i])) {
//                    Else = false; if (question.includes("ANGY")) { setTimeout(botSays, 600, "\nBot : ANGY What would you like to find out about Introductory Programming?") } else { setTimeout(botSays, 600, "\nBot : ANGY How can I help?  Use my commands !Menu & !Tutorial to see what I can do.") }
//                }
//                } else if (question.includes(Actions[i])) {
//                    Else = false; if (question.includes("INFS160 AVAILABLE")) { setTimeout(botSays, 600, "\nBot : It is available in trimester 1 and 3") } else { setTimeout(botSays, 600, "\nBot : What would you like to find out about 2605?") }
//                }
//                }else if (question.includes(Questions[i])) {
//                    Else = false; if (Questions[i].includes("INFS2608 AVAILABLE")) { setTimeout(botSays, 600, "\nBot : This subject is available in Trimester 1 and 3") } else { setTimeout(botSays, 600, "\nBot : How can I help? Use my commands !Menu & !Tutorial to see what I can do.") }
                    else if (question.includes(Greeting[i])) {
                    Else = false; if (Greeting[i].includes("HOW")&&Greeting[i].includes("YOU")) {
                    var reactHello = "How am I";
                    var reactGreeting = "I would say I am 40% complete." }
                    else {
                   num = Math.ceil(Math.random()*3)
                    var reactHello = Greeting[num]
                    reactHello = reactHello.toLowerCase();
                    reactHello = reactHello.charAt(0).toUpperCase() + reactHello.slice(1);
                    var reactGreeting = "Same old. Getting coded mostly.";
                    }
                    var reactPleasant = BotPleasant[num]
                    setTimeout(botSays, 600, "\nBot : " + reactHello + ". " + reactGreeting + " " + reactPleasant )
                  } else if (question.includes(Hello[i])) {
                  var reactHello = Hello[i];
                  reactHello = reactHello.toLowerCase();
                  reactHello = reactHello.charAt(0).toUpperCase() + reactHello.slice(1);
                  var reactGreeting = "";
                  var reactPleasant = ""
                    Else = false;
                      setTimeout(botSays, 600, "\nBot : " + reactHello + ".")
                } else { } }  setTimeout( function() { if (Else === true) {botSays("\n\nSorry! Your request could not be processed. Please visit www.business.unsw.edu.au or call us on 9385 3189. Thanks!"); } } , 700);  setTimeout( function() {Else = true; bot.scrollTop = bot.scrollHeight;}, 730)
            } function botSays(x) {
                document.getElementsByTagName("textarea")[0].innerHTML += x;
            } function youSay(x) { botSays("\n"+ you + " \ : " + x)
            }
            function youDo(x) { botSays("\n"+ you + " " + x)
            } function enterButton(e, x) { if (e.keyCode == 13) { answer(x); }   }