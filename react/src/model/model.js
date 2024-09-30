const API_URL = 'http://localhost:8080/';
const GET_BY_PAIS = 'paises/';

// Obtener todos los países
export async function getAllPaises() {
    const response = await fetch(`${API_URL}paises`);

    if (!response.ok) {
        throw new Error('Error al obtener los países');
    }
    
    return await response.json();
}