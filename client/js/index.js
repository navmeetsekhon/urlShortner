const prefix = "http://localhost:8080/v1";
async function postUrl(originalUrl) {
  try {
    const response = await fetch(prefix+"/createUrl", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
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
    console.error("Error:", error);
    throw error; // Rethrow the error to be caught by the calling function
  }
}

async function shortenUrl() {
  var originalUrl = document.getElementById("originalUrl").value;
  console.log(originalUrl);
  if (!originalUrl) {
    window.alert("enter valid url.");
    return;
  }
  try {
    const key = await postUrl(originalUrl);
    // console.log("Shortened URL:", shortUrl);
    var shortUrl = prefix + key;
    document.getElementById("shortenedUrl").innerHTML =
      "<strong>URL: </strong><a href='" + shortUrl + "'>" + shortUrl + "</a>";
  } catch (error) {
    console.error("Error:", error);
    // Handle errors if necessary
  }
}

async function QrCreate(originalUrl) {
  try {
    const response = await fetch(prefix+"/QrGen", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        // Add any other headers as needed
      },
      body: JSON.stringify({
        url: originalUrl,
      }),
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const responseData = await response.blob();
    const imageObjectURL = URL.createObjectURL(responseData);
    console.log("blob path:"+imageObjectURL);
    return imageObjectURL;
    // return responseData.path; // Assuming the server returns the short URL key
  } catch (error) {
    console.error("Error:", error);
    throw error; // Rethrow the error to be caught by the calling function
  }
}
async function generateQr() {
  var originalUrl = document.getElementById("originalUrl").value;
  if (!originalUrl) {
    window.alert("enter valid url.");
    return;
  }
  try {
    var pathQr = await QrCreate(originalUrl);
    const container = document.getElementById("shortenedUrl");
    const qr = document.createElement("img");
    qr.src = pathQr;
    qr.className="qrOutput";
    qr.alt='QR code';
    qr.style
    container.innerHTML="";
    container.appendChild(qr);
   } catch (error) {
    console.error("Error:", error);
  }
}
function downloadImage() {
  var imgElement = document.getElementById("qrCode");
  var imgUrl = imgElement.src;
  var imgName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
  var a = document.createElement('a');
            a.href = imgUrl;
            a.download = imgName;
            a.style.display = 'none';
            a.target = "_blank";
            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
}
