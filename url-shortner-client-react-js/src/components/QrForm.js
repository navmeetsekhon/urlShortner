import React, { useState } from 'react'
import axios from 'axios';
const QrForm=function QrForm({OnQrGenerated}){
    const [InputTextQr,SetInputTextQr]=useState('');
    const [path,setPath]=useState('');

    const generateQr=async()=>{
        try {
          const response=await axios.post("http://localhost:8080/v1/QrGen",{
            url:InputTextQr
          })
          console.log(typeof(response));
          const responseData = new Blob([response.data]);
          const QrPath = URL.createObjectURL(responseData);
          console.log("QrForm"+typeof(QrPath));
          setPath(QrPath);
          OnQrGenerated(QrPath);
        } catch (error) {
          console.error(error);
        }
      }
      const displayQr = () => {
        generateQr();
        if (path) {
          return <img src={path} alt="qrcode" />;
        }
        return null; // Return null if path is falsy
      };
    return(
        <div className="container">
        <h1 className="title">QR GENERATOR</h1>
        <input 
          className="inputText"
          type="text"
          value={InputTextQr}
          onChange={(e) => {
            SetInputTextQr(e.target.value);
          }}
        />
        <button className="QrGen" type="submit" onClick={generateQr}>Generate QR</button>
        <br />
        {displayQr()}
      <button type="submit">butt</button>
      </div>
    )
}
export default QrForm