SELECT d.id, d.first_name, d.last_name, ds.skill_id, dsp.specialty_id
FROM developer d
INNER JOIN (developer_skills ds, developer_specialty dsp) ON d.id = ds.developer_id AND d.id = dsp.developer_id
WHERE d.id = 2