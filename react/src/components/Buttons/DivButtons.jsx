import Button from "./Button.jsx";
import '../../index.css';

import React, { useState } from 'react';
import { handleGetAllPaises, handleGetSedes } from '../../controller/controller.js';

function DivButtons({setPaises, setSedes}) {
    return (
        <div className="div-left">
            <Button onClick={() => handleGetAllPaises(setPaises)} text="Get All Paises"/>
            <Button onClick={() => handleGetAllPaises(setPaises)} text="Get By Id"/>
            <Button onClick={() => handleGetSedes(setSedes)} text="Query"/>
            <Button onClick={() => handleGetAllPaises(setPaises)} text="Add Pais"/>
            <Button onClick={() => handleGetAllPaises(setPaises)} text="Update Pais"/>
        </div>
    );
}

export default DivButtons;