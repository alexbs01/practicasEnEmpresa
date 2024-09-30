import { getAllPaises } from '../model/model.js';

export const handleGetAllPaises = (setPaises) => {
    console.log('Obteniendo todos los países...');
    getAllPaises()
        .then((data) => {
            console.log('Datos obtenidos:', data);
            setPaises(data)})  // Actualiza el estado con los datos obtenidos
        .catch((error) => console.error('Error al obtener los países:', error));
};