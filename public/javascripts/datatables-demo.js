function getCorrelationData(url, handleData){
    $.ajax({
    type: "GET",
    url: url,
    dataType: "json",
    contentType: "application/json",
    crossDomain: true,
    //            async: false,
    success: function (data) {
    handleData(data);
}
});
}
if(document.getElementById("dataTable")) {
    getCorrelationData("/dashboard/tData", function(output){
    $('#dataTable').DataTable({
    "data": output,
    "processing": true,
    "bPaginate": true,
    "columns": [
                { "data": "budget" },
                { "data": "company" },
                { "data": "country" },
                { "data": "director" },
                { "data": "genre" },
                { "data": "gross" },
                { "data": "name" },
                { "data": "rating" },
                { "data": "released" },
                { "data": "runtime" },
                { "data": "score" },
                { "data": "star" },
                { "data": "votes" },
                { "data": "writer" },
                { "data": "year" }
            ]
    })
    });
}