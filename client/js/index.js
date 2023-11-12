function shortenUrl() {
    var originalUrl = document.getElementById('originalUrl').value;
    // You can implement the URL shortening logic here
    // For simplicity, let's assume the shortened URL is a hash of the original URL
    var shortenedUrl = '#' + Math.random().toString(36).substr(2, 6);
    document.getElementById('shortenedUrl').innerHTML = '<strong>Shortened URL:</strong> ' + shortenedUrl;
}