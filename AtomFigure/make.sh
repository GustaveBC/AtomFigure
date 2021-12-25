
# trash existing bin directory
rm -rf bin >/dev/null 2>&1

# rebuild bin directory
mkdir bin
mkdir bin/main
mkdir bin/img

# trash existing jar file
rm AtomFigure.jar >/dev/null 2>&1

# compile java code to bin
javac -d bin src/main/*.java

# copy images to bin
cp img/*.png bin/img/

# create the jar
cd bin
jar -c -f ../AtomFigure.jar --main-class=main.MainAtom main/*.class img/*.png
cd ..

# done
echo "ready, run with: java -jar AtomFigure.jar"
echo "or explore the jar with: jar -t -f AtomFigure.jar"