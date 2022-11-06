run_main:
	java -jar build/libs/algocoffee-all.jar

run_main_recompile: compile_shadow
	java -jar build/libs/algocoffee-all.jar

run_tests:
	./gradlew build

run_tests_debug:
	./gradlew build --info

report:
	open build/reports/tests/test/index.html

compile_shadow: 
	gradle shadowJar

fetch_data:
	mkdir -p data
	cd data
	wget https://algs4.cs.princeton.edu/code/algs4-data.zip
	unzip -j algs4-data.zip -d .
	rm algs4-data.zip
	cd ..

.PHONY: clean 
clean:
	gradle clean
	rm -rf bin/
	rm -f .classpath
