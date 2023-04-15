# sboot-wasm

Quick start kotlin multiplatform Web Assembly Hello World!

## Usage

If you have wrapper for linux

     ./gradlew assemble

Then execute bellow task to start spring boot

     ./gradlew run

Then launch index.html as http://localhost:8080/index.html
 
All your println from Web Assembly will print on the browser console

![image](https://user-images.githubusercontent.com/9255997/232252333-044b9053-77d3-4646-be9a-7490eb4f514c.png)

or

# Docker - Web

```
docker-compose up -d
```
Access http://localhost:8080

[//]: # (# Docker - Terminal)

[//]: # ()
[//]: # (```)

[//]: # (docker buildx build --platform=wasi/wasm32 -f Dockerfile-wasm -t wasm-docker-app .)

[//]: # (docker run --rm --platform=wasi/wasm32 --runtime=io.containerd.wasmedge.v1 wasm-docker-app)

[//]: # (```)

# References

* [docker-without-containers](https://wasmlabs.dev/articles/docker-without-containers/)
* [docker-and-wasm](https://collabnix.com/docker-and-wasm-containers-better-together/)
* [native-dynamic-libraries](https://kotlinlang.org/docs/native-dynamic-libraries.html#generated-headers-file)