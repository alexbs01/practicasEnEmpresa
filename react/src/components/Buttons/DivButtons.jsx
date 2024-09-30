import ButtonAddPais from "./ButtonAddPais";
import ButtonGetAllPaises from "./ButtonGetAllPaises";
import ButtonGetById from "./ButtonGetById";
import ButtonQuery from "./ButtonQuery";
import ButtonUpdatePais from "./ButtonUpdatePais";
import '../../index.css';

import React, { useState } from 'react';
import { handleGetAllPaises } from '../../controller/controller';

function DivButtons({setPaises}) {
    return (
        <div className="div-left">
            <ButtonGetAllPaises  onClick={() => handleGetAllPaises(setPaises)}/>
            <ButtonGetById />
            <ButtonQuery />
            <ButtonAddPais />
            <ButtonUpdatePais />
        </div>
    );
}

export default DivButtons;