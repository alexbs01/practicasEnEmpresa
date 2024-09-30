import { getAllPaises } from '../model/model.js';

export const handleGetAllPaises = (setPaises) => {
    getAllPaises()
        .then((data) => setPaises(data))  // Actualiza el estado con los datos obtenidos
        .catch((error) => console.error('Error al obtener los países:', error));
};