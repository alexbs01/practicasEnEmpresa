const API_URL = 'http://localhost:8080/';
const GET_BY_PAIS = API_URL + 'paises/';

// Obtener todos los países
export async function getAllPaises() {
    const response = await fetch(`${API_URL}paises`);

    if (!response.ok) {
        throw new Error('Error al obtener los países');
    }
    
    return response.json();
}

// Obtener un país por su ID
export async function getPaisById(id) {
    const response = await fetch(`${GET_BY_PAIS}${id}`);

    if (!response.ok) {
        throw new Error('Error al obtener el país');
    }

    return await response.json();
}

// Query
export async function getSedes() {
    const response = await fetch(`${API_URL}sedes`);

    if (!response.ok) {
        throw new Error('Error al obtener las sedes');
    }

    return await response.json();
}