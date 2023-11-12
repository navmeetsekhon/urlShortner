const prefix='http://localhost:8080/v1/'
async function postUrl(originalUrl) {
    try {
      const response = await fetch('http://localhost:8080/v1/createUrl', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          // Add any other headers as needed
        },
        body: JSON.stringify({
          url: originalUrl,
        }),
      });
  
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
  
      const responseData = await response.json();
      return responseData.key; // Assuming the server returns the short URL key
  
    } catch (error) {
      console.error('Error:', error);
      throw error; // Rethrow the error to be caught by the calling function
    }
  }
  
async function shortenUrl() {
    var originalUrl = document.getElementById("originalUrl").value;
  
    try {
      const key = await postUrl(originalUrl);
      console.log('Shortened URL:', shortUrl);
      var shortUrl=prefix+key
      document.getElementById("shortenedUrl").innerHTML =
        "<strong>URL: </strong><a href='"+shortUrl+"'>" +shortUrl+"</a>";
    } catch (error) {
      console.error('Error:', error);
      // Handle errors if necessary
    }
  }
  