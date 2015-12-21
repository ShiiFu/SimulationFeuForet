foret: sources.txt
	javac @sources.txt

all: clean sources.txt
	javac @sources.txt

sources.txt:
	find -name "*.java" > sources.txt

clean:
	rm -Rf foret/*.class
	rm -Rf foret/*~
	rm -Rf gui/*.class
	rm -Rf gui/*~
	rm -f resultat.png
	rm -f sources.txt

mrproper: clean
