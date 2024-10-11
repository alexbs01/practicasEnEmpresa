import { getAllPaises, getPaisById, getSedes, addPais, updatePais } from '../../model/jjoo/jjooModel.js';

export const handleGetAllPaises = (setPaises) => {
    getAllPaises()
        .then((data) => {
            console.log('Datos obtenidos:', data);
            setPaises(data)})  // Actualiza el estado con los datos obtenidos
        .catch((error) => console.error('Error al obtener los países:', error));
};

export const handleGetById = async (setPaises, id) => {
    try {
        const data = await getPaisById(id); // Espera la respuesta de getPaisById
        console.log('Datos obtenidos:', data);
        setPaises([data]); // Actualiza el estado con los datos obtenidos
        return data; // Retorna los datos
    } catch (error) {
        console.error('Error al obtener el país:', error);
        return null; // Retorna null en caso de error
    }
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

export const handleUpdatePais = (setPaises, id, nombre, codigo, valor) => {
    updatePais(id, nombre, codigo, valor)
        .then((data) => {
            console.log('País actualizado:', data);
            setPaises([data])
        })
        .catch((error) => console.error('Error al actualizar el país:', error));
}