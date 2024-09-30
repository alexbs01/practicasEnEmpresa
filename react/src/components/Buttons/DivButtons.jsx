import ButtonAddPais from "./ButtonAddPais";
import ButtonGetAllPaises from "./ButtonGetAllPaises";
import ButtonGetById from "./ButtonGetById";
import ButtonQuery from "./ButtonQuery";
import ButtonUpdatePais from "./ButtonUpdatePais";
import '../../App.css';

function DivButtons() {
    return (
        <div>
            <ButtonGetAllPaises />
            <ButtonGetById />
            <ButtonQuery />
            <ButtonAddPais />
            <ButtonUpdatePais />
        </div>
    );
}

export default DivButtons;