import { getAllPaises, getPaisById, getSedes, addPais } from '../model/model.js';

export const handleGetAllPaises = (setPaises) => {
    getAllPaises()
        .then((data) => {
            console.log('Datos obtenidos:', data);
            setPaises(data)})  // Actualiza el estado con los datos obtenidos
        .catch((error) => console.error('Error al obtener los países:', error));
};

export const handleGetById = (setPaises, id) => {
    getPaisById(id)
        .then((data) => {
            console.log('Datos obtenidos:', data);
            setPaises([data])})
        .catch((error) => console.error('Error al obtener el país:', error));
};

export const handleGetSedes = (setSedes) => {
    getSedes()
        .then((data) => {
            console.log('Datos obtenidos:', data);
            setSedes(data)})  // Actualiza el estado con los datos obtenidos
        .catch((error) => console.error('Error al obtener las sedes:', error));
};

export const handleAddPais = (setPaises, nombre, codigo, valor) => {
    addPais(nombre, codigo, valor)
        .then((data) => {
            console.log('País agregado:', data);
            setPaises([data])
        })
        .catch((error) => console.error('Error al agregar el país:', error));
}