function testMapReduce() {
    let data = [{time: 1, time2: 1}, {time: 1}, {time: 1}, {time: 1},]

    let total = data.map((x) => {
        return x.time
    }).reduce(
        (a, b) => {
            return a + b
        }
    )
    return total
}
