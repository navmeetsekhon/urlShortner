import React from 'react'
// import QrCode from '/home/navmeet/Desktop/computer programs/projects/url-shortner/urlShortner/src/main/resources/static/QrCodes'
const QrResult=function QrResult(path){
  console.log(typeof(path));
  console.log(path.path);
    return(
        <>
        <div className="outputContainer">
        {path? (
          <div>
            {/* <p>Original url:<a className="original" href={longUrl}>{longUrl}</a></p> */}
                Qr:<img className="qrCode" src={path.path} alt='Qr code' width='100' height='100'></img>
                {/* <button className='qrDownload' onclick='downloadImage()'>Download Qr Code</button> */}
          </div>
        ) : null}
      </div>
        </>
    )
}

export default QrResult;