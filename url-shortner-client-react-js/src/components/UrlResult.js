import React from "react";
import "../css/urlResult.css"

const urlResult = function UrlResult({ longUrl, ShortKey, prefix}) {
  return (
    <>
      <div className="outputContainer">
        {longUrl && ShortKey ? (
          <div>
            <p>Original url:<a className="original" href={longUrl}>{longUrl}</a></p>
            <p>Short url:<a className="short" href={prefix+ShortKey}>{prefix}{ShortKey}</a></p>
          </div>
        ) : null}
      </div>
    </>
  );
};
export default urlResult;
