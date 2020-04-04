
Build JMH Project

`mvn clean install`

Execute program using these flags

```
to - timeout after iteration
wi - number of warm up iterations
w - warmup time
i - number of measurement iterations
r - measurement time
p - params
rf - output format
o - output file name
```

Run loop benchmark

`nohup java -jar target/benchmarks.jar LoopBenchmark -to 60 -wi 0 -i 1 -r 10 -rf csv -rff loop-benchmark-results.csv -o loop-benchmark.log &`

Run dummy client benchmark

`nohup java -jar target/benchmarks.jar DummyBenchmark -to 60 -wi 0 -i 1 -r 5 -rf csv -rff dummy-benchmark-results.csv -o dummy-benchmark.log &`

Run async client benchmark

`nohup java -jar target/benchmarks.jar AsyncBenchmark -to 60 -wi 0 -i 1 -r 5 -rf csv -rff async-benchmark-results.csv -o async-benchmark.log &`

Run http client benchmark

`nohup java -jar target/benchmarks.jar HttpClientBenchmark -to 60 -wi 0 -i 1 -r 5 -rf csv -rff http-client-benchmark-results.csv -o http-client-benchmark.log &`