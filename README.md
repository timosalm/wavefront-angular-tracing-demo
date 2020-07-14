# Wavefront Angular Tracing Demo

### Prerequisites
- JDK 11
- [Node.js](https://nodejs.org/en/about/releases/), npm
- Docker
- Wavefront / [VMware Tanzu Observability](https://tanzu.vmware.com/observability) account

### Start local Wavefront proxy
1. Login to Wavefront, navigate to ***Browse &rarr; Proxies*** and click on ***Add new proxy***. Select ***Docker*** in the ***How to Add a Proxy*** section and copy the command. To enable the ZipKin integration we have to additionally set the environment variable `WAVEFRONT_PROXY_ARGS="--traceZipkinListenerPorts 9411"` and publish the Zipkin listener port `9411`:
```
docker run -d \
    -e WAVEFRONT_URL=https://longboard.wavefront.com/api/ \
    -e WAVEFRONT_TOKEN=MY_TOKEN \
    -e JAVA_HEAP_USAGE=512m \
    -e WAVEFRONT_PROXY_ARGS="--traceZipkinListenerPorts 9411" \
    -p 2878:2878 \
    -p 9411:9411 \
    wavefronthq/proxy:latest
```

### Start the applications
1. Start the API
```
cd wavefront-angular-tracing-demo-api
./mvnw spring-boot:run
```
2. Start the UI
```
cd wavefront-angular-tracing-demo-ui
npm start
```
3. Open your browser **with disabled CORS** on http://localhost:4200/. To start for example a Chrome isntance with disabled CORS on macOS run `open -n -a /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --args --user-data-dir="/tmp/chrome_dev_test" --disable-web-security`


### Additional information
- API `wavefront-spring-boot-starter` dependency documentation: https://docs.wavefront.com/wavefront_springboot.html
- Wavefront Zipkin integration documentation: https://docs.wavefront.com/zipkin.html
- Zipkin JS library repository: https://github.com/openzipkin/zipkin-js#typescript
- Documentation for the the added compilerOptions in tsconfig.app.json: https://github.com/openzipkin/zipkin-js#typescript
- Another option is using https://github.com/ewhauser/angular-tracing

