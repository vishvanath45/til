## Learning dockerize application

[Note] These are my understanding as I gain via experience, thought process may or may not be correct.

- Diff between Dockerfile and docker-compose.yml

Dockerfile is used to build upon images. let's say, you want to add specific extensions on top of image, For example, I want to add geo extension on already existing postgres docker image, then I would use Dockerfile to create 'custom' image and later useit.

docker-compose.yml is used to combine different docker images to set up environment for applciation, so that means if my app uses redis, python, postgres, then I can use all 3 images from docker hub, if I don't need any customization in images. and next use command to run my application.

Can i use docker-compose file without needing Dockerfile?

yes, abosolutely, Dockerfile is needed only when we need custom images, which are not available in docker hub.

Can i use dockerfile without docker-compose?

yes, absolutely, when your application only needs all enviorment in single image, for example, if you have a python script, you can directly use python3 image and run your script from docker file only.

Currently, I am only using docker file to build and deploy app(since i only need to run python script), problem I am facing

- I need to rebuild the image and deploy for any code changes that I do in my python script.
- Use different container name, since once a container is named, it can not be used again it seems, while it is excited, not removed.

