Makefile only works when indented with tab, no spaces.

the format is


target: dependency
	do something

dependency: #empty for no dependency
	do something 
	

while running command make, you either specify single target like `make dependency1` or if you leave it blank, first target in the file will run.

