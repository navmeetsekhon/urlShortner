import React from 'react'
// import QrCode from '/home/navmeet/Desktop/computer programs/projects/url-shortner/urlShortner/src/main/resources/static/QrCodes'
const QrResult=function QrResult({path}){

    const source="../urlShortner/"+path;
    console.log(source);
    return(
        <>
        <div className="outputContainer">
        {path? (
          <div>
            {/* <p>Original url:<a className="original" href={longUrl}>{longUrl}</a></p> */}
            <div>
                Qr:<img className="qrCode" src={source} alt='Qr code' width='200' height='200'></img>
                {/* <button className='qrDownload' onclick='downloadImage()'>Download Qr Code</button> */}
            </div>
          </div>
        ) : null}
      </div>
        </>
    )
}

export default QrResult;