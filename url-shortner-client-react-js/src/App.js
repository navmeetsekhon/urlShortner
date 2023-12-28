// import logo from "./logo.svg";
import "./App.css";
import React, { useState } from "react";
import UrlForm from "./components/UrlForm";
import UrlResult from "./components/UrlResult";
// import QrForm from "./components/QrForm";
// import QrResult from "./components/QrResult";
const prefix="http://localhost:8080/v1/"
function App() {
  const [UrlData, setUrl] = useState({ longUrl: "", ShortKey: "" });
  const [ShowUrl, SetShowUrl] = useState(false);
  // const [QrPath,SetQrPath]=useState({path:""});
  // const [ShowQr, SetShowQr] = useState(false);


  const handleUrl = (NewUrlData) => {
    setUrl(NewUrlData);
    SetShowUrl(true);
  }

  // const handleQr=(QrPath)=>{
  //   console.log(QrPath);
  //   SetQrPath(QrPath);
  //   SetShowQr(true);
  // }

  return (
    <div>
      <UrlForm onUrlShortened={handleUrl} />
      {ShowUrl && (
        <UrlResult longUrl={UrlData.longUrl} ShortKey={UrlData.ShortKey} prefix={prefix} />
      )}
      {/* <QrForm OnQrGenerated={handleQr} />
      {ShowQr && (
        <QrResult path={QrPath.path} />
      )} */}
    </div>
  );
}

export default App;
