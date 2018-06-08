 path  ="D:\sample.DAT"            /* Get file name from command line     */
count=0                     /* Initialize a counter                */
file=.stream~new(path)      /* Create a stream object for the file */
openrc=file~open("read")    /* Open the file for reading           */
if openrc<>"READY:" then do /* Check the return code               */
  say "Could not open" path||"~ RC="||openrc
  exit openrc               /* Bail out                            */
end
hex.30="a"
hex.1="b"
hex.2="c"
hex.3="d"
hex.4="e"
hex.5="f"
hex.6="g"
hex.7="h"
hex.8="i"
hex.9="j"
hex.10="k"
hex.11="l"
hex.12="m"
hex.13="n"
hex.14="o"
hex.15="p"
hex.16="q"
hex.17="r"
hex.18="s"
hex.19="t"
hex.20="u"
hex.21="v"
hex.22="w"
hex.23="x"
hex.24="y"
hex.25="z"
hex.26="T"
hex.27=" "
hex.28="1"
hex.29="2"
hex.31="."
hex.32="<"
hex.33="("
hex.34="+"
hex.35="|"
hex.35="&"
hex.36="!"
hex.37="$"
hex.38="*"
hex.39=")"
hex.40=";"
hex.41="-"
hex.42="/"
hex.43=","
hex.44="_"
hex.45="3"
hex.46="4"
hex.47="5"
hex.48="6"
hex.49="7"
hex.50="8"
hex.51="9"
hex.52="0"
hex.53="_"
hex.54=">"
hex.55="?"
hex.56=":"
hex.57="#"
hex.58="@"
hex.59="`"
hex.60="="
hex.61='\"'
hex.62="["
hex.63="]"
hex.64="{"
hex.65="}"
hex.66="A"
hex.67="B"
hex.68="C"
hex.69="D"
hex.70="E"
hex.71="F"
hex.72="G"
hex.73="H"
hex.74="I"
hex.75="J"
hex.76="K"
hex.77="L"
hex.78="M"
hex.79="N"
hex.80="O"
hex.81="P"
hex.82="Q"
hex.83="R"
hex.84="S"
hex.85="T"
hex.86="U"
hex.87="V"
hex.88="W"
hex.89="X"
hex.90="Y"
hex.91="Z"



a.0="80"
a.1="82"
a.2="83"
a.3="84"
a.4="85"
a.5="86"
a.6="87"
a.7="88"
a.8="89"
a.9="91"
a.10="92"
a.11="93"
a.12="94"
a.13="95"
a.14="96"
a.15="97"
a.16="98"
a.17="99"
a.18="A2"
a.19="A3"
a.20="A4"
a.21="A5"
a.22="A6"
a.23="A7"
a.24="A8"
a.25="A9"
a.26="E3"
a.27="40"
a.28="F1"
a.29="F2"
a.30="81"
a.31="4B"
a.32="4C"
a.33="4D"
a.34="4E"
a.35="4F"
a.35="50"
a.36="5A"
a.37="5B"
a.38="5C"
a.39="5D"
a.40="5E"
a.41="60"
a.42="61"
a.43="6B"
a.44="6C"
a.45="F3"
a.46="F4"
a.47="F5"
a.48="F6"
a.49="F7"
a.50="F8"
a.51="F9"
a.52="F0"
a.53="6D"
a.54="6E"
a.55="6F"
a.56="7A"
a.57="7B"
a.58="7C"
a.59="7D"
a.60="7E"
a.61="7F"
a.62="AD"
a.63="BD"
a.64="C0"
a.65="D0"
a.66="C1"
a.67="C2"
a.68="C3"
a.69="C4"
a.70="C5"
a.71="C6"
a.72="C7"
a.73="C8"
a.74="C9"
a.75="D1"
a.76="D2"
a.77="D3"
a.78="D4"
a.79="D5"
a.80="D6"
a.81="D7"
a.82="D8"
a.83="D9"
a.84="E2"
a.85="E3"
a.86="E4"
a.87="E5"
a.88="E6"
a.89="E7"
a.90="E8"
a.91="E9"



do while file~lines<>0      
    text=file~linein 
    											
        
    conv=C2X(text)										
    l=length(conv)-1                                    /*length of EBCDIC String*/
    i=1                                                 
    k=1
    flag=0
	byte=-1
	do while (byte <> 'X')
	say '   '
    say 'please enter no of bytes to be converted'
    say 'enter -1 for full length conversion'
	say '->Enter X to skip the loop'
    pull byte
    if(datatype(byte,'N')<>1 )            /*condition to check the byte value is a negative or non-integer*/
    then do                                          
        flag=1
	    say please enter length correctly
		iterate                          /*if there is incorrect input skip the loop*/
		
	end
		
	else
		
        if(byte < 0)
		then do
		   
            l=l	
		end
		
        else do
		   l=byte                                          /*consider length as no of bytes*/
		end
		  
        say bytelength is l                                      /* From i=0 loop until i>length or no. of bytes*/
        do until(i > l)                                      /* HEX ARRAY TRAVERSAL LOOP*/	      
           sub=substr(conv,i,2)							 /*grab 2 characters from HEX string which is HEX code */
           j=0
           do until(a.j == sub)               			 /*Traverse  the hex array untill it finds the grabbed HEX code*/
			   
              j=j+1
                  
           end                                            
           str.k=hex.j									/* Take the ASCII code for the same corresponding hex index and send it into seperate array*/
           k=k+1											/*inccrement str array*/
           i=i+2                                           /*increment HEX array with 2 since hex code contains 2 characters at a time*/ 
        end													/*END OF HEX ARRAY TRAVERSAL*/
		
        m=1
        string=""
		if(flag<>1) 
		then do
          do until(m==k)										/*CONCATINATE LOOP*/
               string = string||str.m 							/*Concatinate Array into a string.*/
               m=m+1
          end	                                          		/*END OF CONCATINATE LOOP*/
		 say "EBCDIC String:" text 
        say "ASCII STRING:"string 		/*Dispaly the final converted String*/
		byte="X"
	    end
	end	
  
end
file~close 

                 
